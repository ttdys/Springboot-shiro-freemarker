package com.zjh.tomato.shiro;

import com.zjh.tomato.model.SysMenu;
import com.zjh.tomato.model.SysRole;
import com.zjh.tomato.model.SysUser;
import com.zjh.tomato.service.SysMenuService;
import com.zjh.tomato.service.SysRoleService;
import com.zjh.tomato.service.SysUserService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * shiro认证/授权 自定义realm
 * 使用了喇嘛大表达式
 * list.forEach( one -> 操作)
 *
 * @author zjh on 2019/10/9
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public String getName() {
        return "userRealm";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser sysUser = (SysUser)principalCollection.getPrimaryPrincipal();
        String username = sysUser.getUsername();
        ArrayList<String> sysRoleArrayList = new ArrayList<String>();
        ArrayList<String> permissions = new ArrayList<String>();
        List<SysRole> sysRoleList = sysRoleService.getSysRoleByUsername(username);
        List<SysMenu> sysMenuList = sysMenuService.getSysMenuByUsername(username);
        if(!CollectionUtils.isEmpty(sysRoleList)) {sysRoleList.forEach(role->sysRoleArrayList.add(role.getRoleName()));}
        if(!CollectionUtils.isEmpty(sysMenuList)){sysMenuList.forEach(menu -> permissions.add(menu.getMenuName()));}
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(sysRoleArrayList);
        info.addStringPermissions(permissions);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        if(StringUtils.isEmpty(username)){
            return null;
        }
        SysUser currentUser =sysUserService.getSysUserByUsername(username);
        if(null == currentUser){
            return null;
        }
        ByteSource bytes = ByteSource.Util.bytes(currentUser.getSalt());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(currentUser,currentUser.getPassword(),bytes,getName());
        return info;
    }
}
package com.zjh.tomato.service.impl;

import com.zjh.tomato.dao.SysRoleMapper;
import com.zjh.tomato.model.SysRole;
import com.zjh.tomato.model.SysRoleExample;
import com.zjh.tomato.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 角色service实现类
 *
 * @author zjh on 2019/10/9
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper roleMapper;
    @Override
    public List<SysRole> getSysRoleByUsername(String username) {
        return roleMapper.getSysRoleByUsername(username);

    }

    @Override
    public void deleteRole(Integer roleId) {
        roleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public void updateRole(SysRole sysRole) {
        roleMapper.updateByPrimaryKeySelective(sysRole);
    }

    @Override
    public void addRole(SysRole sysRole) {
        sysRole.setCreateTime(new Date());
        roleMapper.insertSelective(sysRole);
    }

    @Override
    public List<SysRole> getAllRole() {
        return roleMapper.getAllRole();
    }

    @Override
    public void insertRoleMenu(Integer roleId, Integer menuId) {
        roleMapper.insertRoleMenu(roleId,menuId);
    }
}
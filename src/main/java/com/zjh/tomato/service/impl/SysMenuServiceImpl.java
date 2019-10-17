package com.zjh.tomato.service.impl;

import com.zjh.tomato.dao.SysMenuMapper;
import com.zjh.tomato.model.SysMenu;
import com.zjh.tomato.model.SysMenuExample;
import com.zjh.tomato.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单/权限service实现类
 *
 * @author zjh on 2019/10/9
 */
@Service
public class SysMenuServiceImpl  implements SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Override
    public List<SysMenu> getSysMenuByUsername(String username) {
       return sysMenuMapper.getSysMenuByUsername(username);

    }

    @Override
    public List<SysMenu> getAllMenu() {
        List<SysMenu> sysMenuList = sysMenuMapper.selectByExample(new SysMenuExample());
        return sysMenuList;
    }

    @Override
    public void deleteMenu(Integer menuId) {
        sysMenuMapper.deleteByPrimaryKey(menuId);
    }

    @Override
    public void addMenu(SysMenu sysMenu) {
        sysMenuMapper.insertSelective(sysMenu);
    }
}
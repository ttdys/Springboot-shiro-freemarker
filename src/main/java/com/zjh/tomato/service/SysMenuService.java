package com.zjh.tomato.service;

import com.zjh.tomato.model.SysMenu;

import java.util.List;

/**
 * @author zjh on  2019/10/9
 */
public interface SysMenuService {
    List<SysMenu> getSysMenuByUsername(String username);

    List<SysMenu> getAllMenu();

    void deleteMenu(Integer menuId);

    void addMenu(SysMenu sysMenu);
}

package com.zjh.tomato.utils;

import com.zjh.tomato.model.SysMenu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 转换成欠他需要的数据
 *
 * @author zjh on 2019/10/16
 */
public class MenuTreeUtil {

    public static final Integer TREE_ROOT =0;


    public static List<MenuJson> adapterToTree(List<SysMenu> sysMenuList) {
        ArrayList<MenuJson> rootTree = new ArrayList<>();
        sysMenuList.forEach(sysMenu->  {
               if(sysMenu.getParentId().equals(MenuTreeUtil.TREE_ROOT)) {
                   MenuJson menuTree=changeToTree(sysMenu);
                   rootTree.add(menuTree);
               }
        });
            transferChildTree(sysMenuList,rootTree);
        return rootTree;

    }

    private static MenuJson changeToTree(SysMenu sysMenu) {
        MenuJson menuTree = new MenuJson();
        menuTree.setMenuId(sysMenu.getMenuId().longValue());
        menuTree.setMenuName(sysMenu.getMenuName());
        menuTree.setUrl(sysMenu.getUrl());
        menuTree.setSort(sysMenu.getSort());
        menuTree.setMenuType(sysMenu.getMenuType());
        menuTree.setParentId(sysMenu.getParentId().longValue());
        menuTree.setPerms(sysMenu.getPerms());
        return menuTree;
    }

    public static void transferChildTree(List<SysMenu> sysMenuList, List<MenuJson> rootTree) {
       rootTree.forEach(menuTree -> {
           Long menuId = menuTree.getMenuId().longValue();
           sysMenuList.forEach(sysMenu -> {
                if(menuId == sysMenu.getParentId().longValue()) {
                    MenuJson menuJson = changeToTree(sysMenu);
                    menuTree.getChildren().add(menuJson);
                }
           });
           transferChildTree(sysMenuList,menuTree.getChildren());
       });


    }
}
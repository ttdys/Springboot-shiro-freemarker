package com.zjh.tomato.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjh.tomato.model.SysMenu;
import com.zjh.tomato.service.SysMenuService;
import com.zjh.tomato.utils.MenuJson;
import com.zjh.tomato.utils.MenuTreeUtil;
import com.zjh.tomato.utils.PageInfoHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 菜单/权限 Controller
 *
 * @author zjh on 2019/10/9
 */
@Controller
@RequestMapping(value = "menu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;
    @RequestMapping(value = "/list")
    public String getAllMenu()  {
        return "menu/menu-list";
    }

    @RequestMapping("/getMenuTableData")
    @ResponseBody
    public String getMenuTableData(HttpSession session) throws JsonProcessingException {
        List<SysMenu> sysMenuList = sysMenuService.getAllMenu();
        List<MenuJson> jsons = MenuTreeUtil.adapterToTree(sysMenuList);
        /*   model.addAttribute("sysMenuList",sysMenuList);*/
        int size = jsons.size();
        PageInfoHolder<MenuJson> infoHolder = new PageInfoHolder<MenuJson>();
        infoHolder.setDraw(0);
        infoHolder.setRecordsFiltered(Long.valueOf(size));
        infoHolder.setRecordsTotal(Long.valueOf(size));
        infoHolder.setStart(0);
        infoHolder.setLength(size);
        infoHolder.setData(jsons);
        String jsonString = JSONObject.toJSONString(infoHolder);
        session.setAttribute("allMenuList",jsons);
        return jsonString;
    }
    @RequestMapping(value = "/add")
    public String addMenu(SysMenu sysMenu) {
        sysMenuService.addMenu(sysMenu);
        return "";
    }
    @RequestMapping(value = "/update")
    public String updateMenu() {
        return "";
    }
    @RequestMapping(value = "/delete/{menuId}")
    public String deleteMenu(@PathVariable("menuId")Integer menuId) {
        sysMenuService.deleteMenu(menuId);
        return "redirect:/menu/list";
    }
}
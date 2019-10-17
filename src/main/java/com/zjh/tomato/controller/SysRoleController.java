package com.zjh.tomato.controller;

import com.zjh.tomato.model.SysRole;
import com.zjh.tomato.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 角色Controller
 *
 * @author zjh on 2019/10/9
 */
@Controller
@RequestMapping(value = "role")
public class SysRoleController {
    @Autowired
    private SysRoleService roleService;

    @RequestMapping(value = "/list")
    public String getAllRole(Model model) {
        List<SysRole> roleList = roleService.getAllRole();
        model.addAttribute("allRole",roleList);
        return "role/role-list";
    }

    @RequestMapping(value = "/add")
    public String addRole(SysRole sysRole) {
        roleService.addRole(sysRole);
        return "redirect:/role/list";
    }

    @RequestMapping(value = "/update")
    public String updateRole(SysRole sysRole) {
roleService.updateRole(sysRole);
        return "redirect:/role/list";
    }

    @RequestMapping(value = "/delete")
    public String deleteRole(@RequestParam("roleId") Integer roleId) {
        roleService.deleteRole(roleId);
        return "redirect:/role/list";
    }
}
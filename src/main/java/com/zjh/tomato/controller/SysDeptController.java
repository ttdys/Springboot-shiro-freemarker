package com.zjh.tomato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 部门Controller
 *
 * @author zjh on 2019/10/9
 */
@Controller
@RequestMapping(value = "dept")
public class SysDeptController {

    @RequestMapping(value = "/list")
    public String getAllDept() {
        return "dept/dept-list";
    }

    @RequestMapping(value = "/add")
    public String addDept() {
        return "";
    }

    @RequestMapping(value = "/update")
    public String updateDept() {
        return "";
    }

    @RequestMapping(value = "/delete/{deptId}")
    public String deleteDept(@PathVariable("deptId") Integer deptId) {
        return "redirect:/dept/list";
    }
}
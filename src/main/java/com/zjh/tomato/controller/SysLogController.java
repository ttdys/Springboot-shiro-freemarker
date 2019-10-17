package com.zjh.tomato.controller;

import com.zjh.tomato.model.SysActionLog;
import com.zjh.tomato.model.SysLoginLog;
import com.zjh.tomato.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 日志Controller
 *
 * @author zjh on 2019/10/9
 */
@Controller
@RequestMapping(value = "log")
public class SysLogController {

    @Autowired
    private SysLogService logService;

    @RequestMapping(value = "/action")
    public String actionLog(Model model) {
        List<SysActionLog> allActionLog = logService.getAllActionLog();
        model.addAttribute("actionLogList",allActionLog);
        return "log/action-list";
    }
    @RequestMapping(value = "/action/delete/{actionId}")
    public String deleteActionLog(@PathVariable("actionId")Integer actionId) {
        logService.deleteActionLogById(actionId);
        return "redirect:/log/action";
    }


    @RequestMapping(value = "/login")
    public String loginLog(Model model) {
        List<SysLoginLog> allLoginLog = logService.getAllLoginLog();
        model.addAttribute("loginLogList",allLoginLog);
        return "log/login-list";
    }

    @RequestMapping(value = "/login/delete/{loginId}")
    public String deleteLoginLog(@PathVariable("loginId")Integer loginId) {
        logService.deleteLoginLogById(loginId);
        return "redirect:/log/login";
    }
}
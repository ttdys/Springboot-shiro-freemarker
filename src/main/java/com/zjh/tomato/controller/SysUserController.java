package com.zjh.tomato.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjh.tomato.model.SysLoginLog;
import com.zjh.tomato.model.SysMenu;
import com.zjh.tomato.model.SysUser;
import com.zjh.tomato.service.SysLogService;
import com.zjh.tomato.service.SysMenuService;
import com.zjh.tomato.service.SysUserService;
import com.zjh.tomato.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.Date;
import java.util.List;

/**
 * 用户Controller
 *
 * @author zjh on 2019/10/9
 */
@Slf4j
@Controller
@RequestMapping("user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysLogService logService;
    @Autowired
    private SysMenuService sysMenuService;

    @RequestMapping("/login")
    public String login(SysUser sysUser, HttpServletRequest request) {
        log.info("到达SysUserController了");
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getUsername(),sysUser.getPassword());
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);

            SysUser user = (SysUser)subject.getPrincipal();
            Session session = subject.getSession();
            log.info("登陆成功 username是{}",user.getUsername());
            List<SysMenu> sysMenuList = sysMenuService.getSysMenuByUsername(user.getUsername());
            session.setAttribute("currentUser",user);
            HttpSession session1 = request.getSession();
            session1.setAttribute("myMenu",sysMenuList);
            SysLoginLog loginLog = LoginLogUtil.loadLog(request, user.getUsername());
            logService.addLoginLog(loginLog);

            return "index";
        } catch (Exception e)  {
            e.printStackTrace();
            log.error("登陆失败");
            return "redirect:/page/login";
        }
    }


    @RequestMapping("/menuList")
    @ResponseBody
    public String getAllMenuList() throws JsonProcessingException {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        List<SysMenu> sysMenuList = sysMenuService.getSysMenuByUsername(user.getUsername());
        List<MenuJson> menuTrees = MenuTreeUtil.adapterToTree(sysMenuList);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(menuTrees);
        System.out.println("jsonString = " + jsonString);
        return jsonString ;
    }

    @RequestMapping(value = "/list")
    public String getAllUser(Model model) {
        List<SysUser> userList = sysUserService.getAllUser();
        model.addAttribute("userList",userList);
        return "user/user-list";
    }

    @RequestMapping(value = "/add")
    public String addUser(SysUser sysUser) {
        sysUserService.addUser(sysUser);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/update")
    public String updateUser(SysUser sysUser) {
        sysUserService.updateUser(sysUser);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Integer userId) {
        sysUserService.deleteUser(userId);
        return "redirect:/user/list";
    }

}

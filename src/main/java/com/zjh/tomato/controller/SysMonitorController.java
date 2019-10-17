package com.zjh.tomato.controller;

import com.zjh.tomato.model.Online;
import com.zjh.tomato.model.SysUser;
import com.zjh.tomato.utils.LocationUtils;
import com.zjh.tomato.utils.SystemUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 监控Controller
 *
 * @author zjh on 2019/10/9
 */
@Controller
@RequestMapping(value = "monitor")
public class SysMonitorController {
    @Autowired
    private SessionDAO sessionDAO;

 @Autowired
 private HttpServletRequest request;

    @RequestMapping("/online")
    public String monitorOnline(Model model) {
        Collection<Session> activeSessions = sessionDAO.getActiveSessions();
        Session session = SecurityUtils.getSubject().getSession();
        ArrayList<Online> onlineArrayList = new ArrayList<>();

        for (Session activeSession : activeSessions) {
            PrincipalCollection principalCollection;
            if(null ==activeSession.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)){
                continue;
            } else {
                principalCollection = (PrincipalCollection) activeSession.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
                SysUser sysUser = (SysUser) principalCollection.getPrimaryPrincipal();
               Online online = new Online();
               online.setUsername(sysUser.getUsername());
               online.setSessionId(activeSession.getId().toString());
               online.setIp(activeSession.getHost());
               online.setLocation(LocationUtils.getAddr(activeSession.getHost()));
                if (null != request) {
                    online.setOS(SystemUtils.getRequestSystemInfo(request));
                    online.setBrowser(SystemUtils.getBrowserInfo(request));
                }
                if(session.getId().equals(activeSession.getId())){
                    online.setCurrent(true);
                } else {
                    online.setCurrent(false);
                }
               online.setLastTime(activeSession.getLastAccessTime());
               online.setLoginTime(activeSession.getStartTimestamp());
               onlineArrayList.add(online);
            }
        }
        model.addAttribute("onlineArrayList",onlineArrayList);
        return "monitor/online-list";
    }


    @RequestMapping("/online/forceLogout")
    public String forceLogout(@RequestParam("sessionId")String sessionId) {
        Session session = sessionDAO.readSession(sessionId);
        session.setTimeout(0);
        session.stop();
        sessionDAO.delete(session);
        return "redirect:/monitor/online";
    }

    @RequestMapping(value = "/tomcat")
    public String monitorTomcat() {
        return "";
    }
    @RequestMapping(value = "/server")
    public String monitorServer() {
        return "";
    }
    @RequestMapping(value = "/JVM")
    public String monitorJVM() {
        return "";
    }
    @RequestMapping(value = "/druid")
    public String monitorDRUID() {
        return "redirect:/druid/index.html";
    }
}
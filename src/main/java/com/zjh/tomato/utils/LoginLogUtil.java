package com.zjh.tomato.utils;

import com.zjh.tomato.model.SysLoginLog;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 *get登录日志工具类
 *
 * @author zjh on 2019/10/10
 */
public class LoginLogUtil {
    /**
     * @param request
     */
    public static SysLoginLog loadLog(HttpServletRequest request,String username) {
        // 获取操作系统信息
        String requestSystemInfo = SystemUtils.getRequestSystemInfo(request);
        String browserInfo = SystemUtils.getBrowserInfo(request);
        String ipAddr = SystemUtils.getIpAddr(request);
        String addr = LocationUtils.getAddr(ipAddr);
        SysLoginLog loginLog = new SysLoginLog();
        loginLog.setIp(ipAddr);
        loginLog.setAddr(addr);
        loginLog.setBrowser(browserInfo);
        loginLog.setOs(requestSystemInfo);
        loginLog.setLastTime(new Date());
        loginLog.setUsername(username);
        return loginLog;
    }
}
package com.zjh.tomato.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjh.tomato.controller.PageController;
import com.zjh.tomato.controller.SysLogController;
import com.zjh.tomato.model.SysActionLog;
import com.zjh.tomato.model.SysUser;
import com.zjh.tomato.service.SysLogService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 记录日志
 * javadoc的形式  /**开头
 *
 * @author zjh on 2019/10/10
 */
@Aspect
@Component
public class AopLog {

    @Autowired
    private SysLogService logService;

    private String username;

    private String item;

    private String method;

    private String params;

    private Long actionTime;

    private String result;

    private String error;

    private String remark;

    private Class executionClass;

    /**
     * 前置处理
     *
     * @param joinPoint
     */
    @Before("execution(* com.zjh.tomato.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        executionClass = joinPoint.getTarget().getClass();
        //如果是查看登陆页面/日志/监控的controller直接返回
        if (PageController.class == executionClass) {
            return;
        }
        if (SysLogController.class == executionClass) {
            return;
        }
        System.out.println(" =========befre============== ");
        actionTime = System.currentTimeMillis();
        //获取访问的controller
        executionClass = joinPoint.getTarget().getClass();

        //获取执行的目标方法名称
        method = joinPoint.getSignature().getName();

         item = executionClass.getName();
        //获取方法的参数列表
        Object[] args = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        if(null == args && args.length ==0) {
            sb.append("");
        } else {
            for (int i=0; i<args.length; i++) {
                if (i == args.length-1) {
                    sb.append(args[i]);
                    break;
                }
                sb.append( args[i]+"/");
            }
        }
        params = sb.toString();
        System.out.println("params = " + params);
    }

    @After("execution(* com.zjh.tomato.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) throws Exception {
        if (PageController.class == executionClass) {
            return;
        }
        actionTime = System.currentTimeMillis() - actionTime;
        Subject subject = SecurityUtils.getSubject();
        SysUser currentUser = (SysUser) subject.getPrincipal();
        if (currentUser == null) {
            return ;
        }
        username = currentUser.getUsername();
        System.out.println(" =========after============== ");
    }
    /**
     * 后置处理
     * @After ---->@AfterReturning
     * 解释：执行到核心业务方法或者类时，会先执行AOP。
     * 在aop的逻辑内，先走@Around注解的方法。然后是@Before注解的方法，
     * 然后这两个都通过了，走核心代码，核心代码走完，无论核心有没有返回值，
     * 都会走@After方法。
     * 然后如果程序无异常，
     * 正常返回就走@AfterReturn,
     * 有异常就走@AfterThrowing。
     *
     * @param joinPoint
     */

    @AfterReturning(returning = "obj", pointcut = "execution(* com.zjh.tomato.controller.*.*(..))")
    public void doAfterReturning(JoinPoint joinPoint,Object obj) throws Exception {
        if (PageController.class == executionClass) {
            return;
        }
        if (SysLogController.class == executionClass) {
            return;
        }

        result = obj.toString();
        if(result.length() >50) {
            result = obj.getClass().getName();
        }
        HashMap<String,String> map = new HashMap<>();
        map.put("result",result);
        map.put("error","");
        saveSysActionLog(map);
        System.out.println("obj AfterReturning= " + obj);
    }

    @AfterThrowing(throwing = "obj", pointcut = "execution(* com.zjh.tomato.controller.*.*(..))")
    public void doAfterThrowing(JoinPoint joinPoint,Throwable obj){
        if (PageController.class == executionClass) {
            return;
        }
        if (SysLogController.class == executionClass) {
            return;
        }
        error = obj.getMessage();
        HashMap<String,String> map = new HashMap<>();
        map.put("result","");
        map.put("error",error);
        saveSysActionLog(map);
        System.out.println("obj AfterThrowing= " + obj);
    }

    public  void saveSysActionLog(Map<String,String> map) {
        SysActionLog actionLog = new SysActionLog();
        actionLog.setActionTime(actionTime);
        actionLog.setItem(item);
        actionLog.setParams(params);
        actionLog.setMethod(method);
        actionLog.setUsername(username);
        actionLog.setResult(map.get("result"));
        actionLog.setError(map.get("error"));
        System.out.println("actionLog.toString() = " + actionLog.toString());
        logService.addActionLog(actionLog);
    }
}
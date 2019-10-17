package com.zjh.tomato.model;

import lombok.Data;

import java.util.Date;

/**
 * 在线用户类DTOlei
 *
 * @author zjh on 2019/10/16
 */
@Data
public class Online {

    private String sessionId;
    private String username;
    private boolean current;
    private String ip;
    private String location;
    private String OS;
    private String browser;
    private Date loginTime;
    private Date lastTime;

}
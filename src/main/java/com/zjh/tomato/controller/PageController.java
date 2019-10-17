package com.zjh.tomato.controller;

import com.zjh.tomato.utils.VerifyCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 验证码/首页
 *
 * @author zjh on 2019/10/9
 */
@Slf4j
@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("/indext")
    public String indext(){
        return "index";
    }
    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/getVerifyCode")
    public void getVerifyCode(HttpServletResponse response, HttpServletRequest request) {
        try {
            int width = 200;
            int height = 69;

            BufferedImage verifyImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            //生成对应宽高的初始图片

            String randomText = VerifyCode.drawRandomText(width, height, verifyImg);

            //单独的一个类方法，出于代码复用考虑，进行了封装。

            //功能是生成验证码字符并加上噪点，干扰线，返回值为验证码字符

            request.getSession().setAttribute("verifyCode", randomText);
            //必须设置响应内容类型为图片，否则前台不识别
            response.setContentType("image/png");
            //获取文件输出流
            OutputStream os = response.getOutputStream();
            //输出图片流
            ImageIO.write(verifyImg, "png", os);

            os.flush();

            os.close();//关闭流

        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    @RequestMapping("/{orange}/list")
    public String listPage(@PathVariable("orange") String orange) {
        return orange+"/"+orange+"-list";
    }

    @RequestMapping("/{orange}/add")
    public String addPage(@PathVariable("orange") String orange) {
        return "";
    }

    @RequestMapping("/{orange}/update")
    public String updatePage(@PathVariable("orange") String orange) {
        return "";
    }

}
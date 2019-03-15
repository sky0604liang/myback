package com.back.controller;

import com.back.util.ImageCodeUtil;
import com.back.util.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@Log4j2
public class HomeController {

//    @RequestMapping({"/","/index"})
//    public String index(){
//        return "/back/index";
//    }
    @RequestMapping(value = {"/", "index.html"})
    public String index(){
        return "back/index";
    }
    @RequestMapping("/login")
    public String login(){
        return "/login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }

    /**
     * 退出
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        return "redirect:login.html";
    }


    /**
     * 生成验证码
     */
    @RequestMapping(value = "/getVerify",method = RequestMethod.GET)
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            ImageCodeUtil randomValidateCode = new ImageCodeUtil();
            log.info("获取验证码================================="+randomValidateCode);
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            log.info("获取验证码失败>>>> ", e);
        }
    }

}

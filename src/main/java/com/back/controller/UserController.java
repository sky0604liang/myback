package com.back.controller;

import com.back.pojo.SysUser;
import com.back.service.SysUserService;
import com.back.util.Result;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("user")
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/loginByPhone")
    @ResponseBody
    public Result loginByPhone(String phone, String password){
        log.info("loginByPhone=====登录==="+phone);
        return sysUserService.selectByPhoneLogin(phone,password);
    }

}

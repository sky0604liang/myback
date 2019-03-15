package com.back.service.impl;

import com.back.mapper.SysUserMapper;
import com.back.pojo.SysUser;
import com.back.service.SysUserService;
import com.back.util.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class SysUserServiceImpl implements SysUserService {


    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> selectAll() {
        return sysUserMapper.selectAll();
    }

    @Override
    public Result selectByPhoneLogin(String phone, String password) {
        SysUser sysUser = sysUserMapper.selectByPhoneLogin(phone,password);
        if (sysUser == null){
            return Result.error(404,"没有该用户！");
        }
        else if (!sysUser.getPassword().equalsIgnoreCase(password)){
            return Result.error(405,"输入正确的密码！");
        }else if (sysUser.getLocked().equals("1")){
            return Result.error(406,"账号锁定！");
        }
        return Result.ok("欢迎您"+sysUser.getUsername());
    }
}

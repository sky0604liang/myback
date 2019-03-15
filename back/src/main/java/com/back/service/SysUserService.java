package com.back.service;

import com.back.pojo.SysUser;
import com.back.util.Result;

import java.util.List;

public interface SysUserService {

    /**
     * 查询全部系统用户
     * @return
     */
    List<SysUser> selectAll();

    /**
     * 根据电话号码查询是否有该用户
     * @return
     */
    Result selectByPhoneLogin(String phone, String password);
}

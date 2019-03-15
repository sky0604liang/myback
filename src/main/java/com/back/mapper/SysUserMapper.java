package com.back.mapper;

import com.back.pojo.SysUser;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface SysUserMapper extends Mapper<SysUser> {



    SysUser selectByPhoneLogin(@Param("phone")String phone,@Param("password")String password);
}
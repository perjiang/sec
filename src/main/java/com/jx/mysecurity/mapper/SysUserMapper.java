package com.jx.mysecurity.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jx.mysecurity.entity.SysUser;

/**
 * @author Administrator
 */


public interface SysUserMapper extends BaseMapper<SysUser> {
    SysUser selectSysUserByUserName(String username);
}

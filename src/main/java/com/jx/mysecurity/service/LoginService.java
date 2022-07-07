package com.jx.mysecurity.service;

import com.jx.mysecurity.entity.SysUser;
import com.jx.mysecurity.util.Result;

/**
 * @author Administrator
 */
public interface LoginService {

    Result login(SysUser sysUser);
}

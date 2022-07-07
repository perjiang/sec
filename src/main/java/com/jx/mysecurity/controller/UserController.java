package com.jx.mysecurity.controller;

import com.jx.mysecurity.entity.SysUser;
import com.jx.mysecurity.service.LoginService;
import com.jx.mysecurity.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author
 * @Date 2022/7/7 16:22
 */

@RestController
public class UserController {

    @Autowired
    LoginService loginService;

    @GetMapping("/user/login")
    public Result login(@RequestBody SysUser sysUser){
        if (Objects.isNull(sysUser)){
            return Result.fail("信息不完全");
        }

        return loginService.login(sysUser);
    }
}

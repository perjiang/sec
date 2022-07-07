package com.jx.mysecurity.service.impl;

import com.google.gson.Gson;
import com.jx.mysecurity.entity.LoginUser;
import com.jx.mysecurity.entity.SysUser;
import com.jx.mysecurity.service.LoginService;
import com.jx.mysecurity.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.RequestDispatcher;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;

/**
 * @ClassName LoginServiceImpl
 * @Description TODO
 * @Author
 * @Date 2022/7/7 16:27
 */

@Service
public class LoginServiceImpl  implements LoginService {
    public static final String LOGIN_KEY = "login:key";

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    RedisTemplate<String,String> redisTemplate;
    @Override
    public Result login(SysUser sysUser) {
        if (!(StringUtils.hasText(sysUser.getUsername())) || !(StringUtils.hasText(sysUser.getPassword()))){
            return Result.fail("参数不正确");
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(sysUser.getUsername(),sysUser.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        LoginUser loginUser = (LoginUser)authenticate.getPrincipal();
        // 生成随机token
        String token = UUID.randomUUID().toString();
        // 吧token存入redis
        Gson gson = new Gson();
        String json = gson.toJson(loginUser);
        redisTemplate.opsForValue().set(token,json,30, TimeUnit.MINUTES);
        return Result.ok(token);
    }
}

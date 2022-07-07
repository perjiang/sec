package com.jx.mysecurity.entity;

import lombok.Data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;

/**
 * @ClassName LoginUser
 * @Description TODO
 * @Author
 * @Date 2022/7/7 16:36
 */

public class LoginUser  extends User {
    @Getter
    @Setter
    private SysUser sysUser;

    public LoginUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username,password,true, true, true, true,  authorities);
    }


}

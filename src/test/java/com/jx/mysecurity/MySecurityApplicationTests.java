package com.jx.mysecurity;

import com.jx.mysecurity.entity.SysUser;
import com.jx.mysecurity.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest(classes = MySecurityApplication.class)
class MySecurityApplicationTests {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Test
    void contextLoads() {
        System.out.println(bCryptPasswordEncoder.encode("123456"));
    }

}

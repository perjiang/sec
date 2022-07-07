package com.jx.mysecurity.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jx.mysecurity.entity.LoginUser;
import com.jx.mysecurity.entity.SysUser;
import com.jx.mysecurity.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName MyUserDetailService
 * @Description TODO
 * @Author
 * @Date 2022/7/7 16:36
 */
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getUsername,username);
        SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
        if (Objects.isNull(sysUser)){
            throw new RuntimeException("用户名或者密码错误");
        }
        // 手动给用户添加角色
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("admin"));
        LoginUser loginUser = new LoginUser(sysUser.getUsername(), sysUser.getPassword(), authorityList );
        loginUser.setSysUser(sysUser);
        return loginUser;
    }
}

package com.jx.mysecurity.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jx.mysecurity.entity.LoginUser;
import com.jx.mysecurity.entity.SysPermission;
import com.jx.mysecurity.entity.SysRole;
import com.jx.mysecurity.entity.SysUser;
import com.jx.mysecurity.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName MyUserDetailService
 * @Description TODO
 * @Author
 * @Date 2022/7/7 16:36
 */
@Service
public class MyUserDetailService implements UserDetailsService {

    public static final String PRE = "ROLE_";

    @Autowired
    private SysUserMapper sysUserMapper;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser sysUser = sysUserMapper.selectSysUserByUserName(username);
        if (Objects.isNull(sysUser)){
            throw new RuntimeException("用户名或者密码错误");
        }
        // 手动给用户添加角色
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        List<SysRole> rolesList = sysUser.getRolesList();
        for (SysRole sysRole : rolesList) {
            authorityList.add(new SimpleGrantedAuthority(PRE + sysRole.getRoleName()));
            List<SysPermission> permissionList = sysRole.getPermissionList();
            for (SysPermission sysPermission : permissionList) {
                authorityList.add(new SimpleGrantedAuthority(sysPermission.getPermissionName()));
            }
        }
        LoginUser loginUser = new LoginUser(sysUser, authorityList );
        loginUser.setSysUser(sysUser);
        return loginUser;
    }
}

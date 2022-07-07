package com.jx.mysecurity.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @ClassName SysUser
 * @Description TODO
 * @Author
 * @Date 2022/7/7 16:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("user")
public class SysUser {
    @TableId
    private int id;
    private String username;
    private String password;
}

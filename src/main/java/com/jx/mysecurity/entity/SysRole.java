package com.jx.mysecurity.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description:
 * @author: jiangxing
 * @createDate: 2022/7/7
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("role")
public class SysRole {

    @TableField("role_id")
    private int id;

    @TableField("role_name")
    private String roleName;

    @TableField(exist = false)
    private List<SysPermission> permissionList;
}

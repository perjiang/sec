package com.jx.mysecurity.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: jiangxing
 * @createDate: 2022/7/7
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@TableName("permission")
public class SysPermission {

    @TableField("id")
    private int id;
    @TableField("name")
    private String permissionName;

    public SysPermission(){}
}

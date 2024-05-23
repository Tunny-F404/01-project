package com.zeroone.star.sysmanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@TableName("sys_menu")
public class Menu implements Serializable {

    private String menu_id;
    private String menu_name;
    private String parent_id;
    private int order_num;
    private String path;
    private String component;
    private String query;
    private int is_frame;
    private int is_cache;
    private String menu_type;
    private int visible;
    private int status;
    private String perms;
    private String icon;
    private String create_by;
    private String create_time;
    private String update_by;
    private String update_time;
    private String remark;

}

package com.zeroone.star.project.j2.sysmanagement.dto.menu;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.util.Date;

/**
 * @author 熠 Di
 * @version 1.0.0
 * @Description: TODO
 */

@Data
@ApiOperation("系统管理数据对象")
public class MenuDTO {
    public String getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getOrder_num() {
        return order_num;
    }

    public void setOrder_num(Integer order_num) {
        this.order_num = order_num;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getIs_frame() {
        return is_frame;
    }

    public void setIs_frame(int is_frame) {
        this.is_frame = is_frame;
    }

    public int getIs_cache() {
        return is_cache;
    }

    public void setIs_cache(int is_cache) {
        this.is_cache = is_cache;
    }

    public String getMenu_type() {
        return menu_type;
    }

    public void setMenu_type(String menu_type) {
        this.menu_type = menu_type;
    }

    public char getVisible() {
        return visible;
    }

    public void setVisible(char visible) {
        this.visible = visible;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    //菜单ID
    @ApiModelProperty(value = "菜单ID",example = "1")
    private String menu_id;


    //菜单名称
    @ApiModelProperty(value = "菜单名称",example = "部门管理")
    private String menu_name;

    //父菜单ID
    @ApiModelProperty(value = "父级ID",example = "1")
    private Integer parent_id;

    //显示顺序
    @ApiModelProperty(value = "显示顺序",example = "1")
    private Integer order_num;

    //路由地址
    @ApiModelProperty(value = "路由地址",example = "ip")
    private String path;

    //组件路径
    @ApiModelProperty(value = "组件路径",example = "ip")
    private String component;

    //路由参数
    @ApiModelProperty(value = "路由参数",example = "ip")
    private String query;

    //是否外链
    @ApiModelProperty(value = "是否外链",example = "0")
    private int is_frame;

    //是否缓存
    @ApiModelProperty(value = "是否缓存",example = "0")
    private int is_cache;

    //菜单类型
    @ApiModelProperty(value = "菜单类型",example = "目录")
    private String menu_type;

    //菜单状态
    @ApiModelProperty(value = "菜单状态",example = "0")
    private char visible;

    //菜单状态
    @ApiModelProperty(value = "菜单状态",example = "0")
    private String status;

    //权限标识
    @ApiModelProperty(value = "权限标识",example = "0")
    private String perms;

    //菜单图标
    @ApiModelProperty(value = "菜单图标",example = "0")
    private String icon;

    //创建着
    @ApiModelProperty(value = "创建人",example = "0")
    private String create_by;

    //创建时间
    @ApiModelProperty(value = "创建时间",example = "0")
    private Date create_time;

    //更新者
    @ApiModelProperty(value = "更新者人",example = "0")
    private String update_by;

    //更新时间
    @ApiModelProperty(value = "更新时间",example = "0")
    private Date update_time;

    //备注
    @ApiModelProperty(value = "备注",example = "0")
    private String remark;
}

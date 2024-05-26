package com.zeroone.star.project.j1.orgstructure.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 *
 * @author Tme
 * @version 1.0.0
 */
@Data
@ApiModel("用户列表数据模型")
public class UserDTO {
    //页码
    @Min(value = 1,message = "页码不能小于1")
    @ApiModelProperty(value = "查询页码",example = "1")
    private long pageIndex;
    //数据条数
    @Min(value = 1,message = "数据条数不能小于1")
    @ApiModelProperty(value = "查询数据条数",example = "10")
    private long pageSize;
    @NotEmpty(message = "用户ID不能为空")
    @ApiModelProperty(value = "用户ID", example = "1")
    private Long userId;
    @ApiModelProperty(value = "用户名称", example = "admin")
    private String userName;
    @ApiModelProperty(value = "用户昵称", example = "若依")
    private String nickName;
    @ApiModelProperty(value = "部门名称", example = "生产部")
    private String dept;
    @ApiModelProperty(value = "手机号码", example = "18888888888")
    private String phonenumber;
    @ApiModelProperty(value = "用户账号状态(0:正常 1:停用)", example = "1")
    private String status;
    @ApiModelProperty(value = "创建时间", example = "2024-05-20 00:02:30")
    private String createTime;


    /**
     * 角色编号
     */
    @ApiModelProperty(value = "角色编号", example = "1")
    private String roleId;
    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名字", example = "测试员")
    private String roleName;
    /**
     * 权限字符
     */
    @ApiModelProperty(value = "权限字符", example = "tester")
    private String roleKey;
}

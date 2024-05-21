package com.zeroone.star.project.j5.teamsettings.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Liang
 * @Date: 2024/05/21/19:05
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamMemberVO {
    private String searchValue;
    private String createBy;
    private String createTime;
    private String updateBy;
    private String updateTime;
    private String remark;
    private Integer teamId;
    private String teamCode;
    private String teamName;
    private String calendarType;
    private String attr1;
    private String attr2;
    private Integer attr3;
    private Integer attr4;
}

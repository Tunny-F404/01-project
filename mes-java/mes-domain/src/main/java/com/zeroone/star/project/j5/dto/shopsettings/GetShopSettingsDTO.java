package com.zeroone.star.project.j5.dto.shopsettings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetShopSettingsDTO implements Serializable {
    private Long workshop_id;
    private String workshop_code;
    private String workshop_name;
    private Double area;
    private String charge;
    private String enable_flag;
    private String remark;
    private String attr1;
    private String attr2;
    private Integer attr3;
    private Integer attr4;
    private String create_by;
    private Date create_time;
    private String update_by;
    private Date update_time;

}

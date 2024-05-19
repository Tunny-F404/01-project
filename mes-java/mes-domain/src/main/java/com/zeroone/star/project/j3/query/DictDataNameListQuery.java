package com.zeroone.star.project.j3.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("获取字典类型对应字典数据名列表对象")
public class DictDataNameListQuery {

    @ApiModelProperty(value = "字典类型", example = "sys_user_sex")
    private String dictType;

}

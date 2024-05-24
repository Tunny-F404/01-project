package com.zeroone.star.sysmanagement.mapstruct;


import com.zeroone.star.sysmanagement.Constants.configConstant;
import org.springframework.stereotype.Component;

/**
 * @Author: 40斤
 * @CreateTime: 2024-05-24  11:27
 * @Description: TODO
 * @Version: 1.0
 */
@Component
public class strToStrStrategy {
    public String strToStr(String configType){
        if (configType.equals(configConstant.YES)){
            return "是";
        }else if (configType.equals(configConstant.NO)){
            return "否";
        }else {
            return configType;
        }
    }
}

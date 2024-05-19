package com.zeroone.star.project.j6.customer;

import com.zeroone.star.project.j1.dto.dept.DeptTableDTO;
import com.zeroone.star.project.vo.JsonVO;

/**
 * <p>
 * 描述：下载模板结果返回接口定义
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 快乐小新
 * @version 1.0.0
 */
public interface DownloadTemplateApis {

    /**
     *
     * @return 返回下载模板情况
     */
    JsonVO<DeptTableDTO> DownloadResult();
}

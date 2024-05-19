package com.zeroone.star.project.j1.dept;

import com.zeroone.star.project.j1.dto.dept.DeptTableDTO;
import com.zeroone.star.project.j1.query.dept.DeptQuery;
import com.zeroone.star.project.vo.JsonVO;

import java.util.List;

/**
 * <p>
 * 描述：部门管理接口
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 阿伟学长
 * @version 1.0.0
 */
public interface DeptApis {
    /**
     * 获取部门列表
     * @param deptQuery 查询条件对象
     * @return 查询结果
     */
    JsonVO<List<DeptTableDTO>> queryDeptList(DeptQuery deptQuery);
}

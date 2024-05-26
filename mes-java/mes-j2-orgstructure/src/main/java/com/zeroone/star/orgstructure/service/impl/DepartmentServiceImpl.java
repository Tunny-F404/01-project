package com.zeroone.star.orgstructure.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.orgstructure.entity.Department;
import com.zeroone.star.orgstructure.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeroone.star.project.dto.PageDTO;
import com.zeroone.star.project.j2.orgstructure.dto.dept.DepartmentDTO;
import com.zeroone.star.project.j2.orgstructure.query.dept.DepartmentQuery;
import com.zeroone.star.project.j2.orgstructure.vo.DepartmentTreeVO;
import com.zeroone.star.project.j2.orgstructure.vo.QueryDepartmentTreeVO;
import com.zeroone.star.project.utils.tree.TreeNode;
import com.zeroone.star.project.utils.tree.TreeNodeMapper;
import com.zeroone.star.project.utils.tree.TreeUtils;
import io.swagger.models.auth.In;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * Tree转化器
 * </p>
 *
 * @author cq
 * @since 2024-05-22
 */
class DepartmentTreeNodeMapper implements TreeNodeMapper<Department> {
    private List<Integer> mRoot ;//根节点id

    public DepartmentTreeNodeMapper(){//无参构造 不使用

    }
    public DepartmentTreeNodeMapper(List<Integer> root){//有参构造使用有参构造确认root节点
        mRoot = root;//浅拷贝没有问题，只需要拿出值判断
    }

    @Override
    public TreeNode objectMapper(Department department) {
        DepartmentTreeVO treenode = new DepartmentTreeVO();
        treenode.setTnId(department.getDeptId().toString());
        if (department.getParentId() == null || isRootId(department.getDeptId())) {//如果父亲id不存在
            treenode.setTnPid((null));//设置空父亲
        } else {
            treenode.setTnPid(department.getParentId().toString());
        }
        treenode.setDeptName(department.getDeptName());
        treenode.setId(department.getDeptId());
        treenode.setFId(department.getParentId());
        return treenode;
    }

    public boolean isRootId(Integer id){
        for (Integer node:mRoot){
            if(node.equals(id))
                return true;
        }
        return false;
    }

}


/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author 宵夜
 * @since 2024-05-22
 */

@Mapper(componentModel = "spring")
interface MsDepartmentMapper {
    /**
     * 将department转换为departmentDTO
     *
     * @param department
     * @return
     */
    DepartmentDTO departmentOToDepartmentDTO(Department department);

    /**
     * 将department转换为departmentDTO
     *
     * @param departmentDTO
     * @return
     */
    Department departmentDTOToDepartment(DepartmentDTO departmentDTO);
}


@Service
public class DepartmentServiceImpl extends ServiceImpl<com.zeroone.star.orgstructure.mapper.DepartmentMapper, Department> implements DepartmentService {

    @Resource
    MsDepartmentMapper msDepartmentMapper;

    @Override
    public List<DepartmentTreeVO> getDepartmentNameTree(String name) {
        //定义数据容器
        List<Department> departments = new ArrayList<>();
        List<Department> t = baseMapper.selectByNameOne(name);//查询的部门本体(相当于root) 可能查询到同名的部门
        departments.addAll(t);
        List<Integer> ids = new ArrayList<>();
        for (Department root : departments) {//查询到多个名字相同的部门 全部加入待查寻集中
            ids.add(root.getDeptId());
        }
        List<Integer> root = new ArrayList<>();//根节点id
        for (Department node : departments) {//深拷贝
            root.add(node.getDeptId());
        }
        for (int i = 0; i < ids.size(); i++) {
            List<Department> tDept = baseMapper.selectByName(ids.get(i));
            if (tDept != null && !tDept.isEmpty()){
                departments.addAll(tDept);
                for (Department node : tDept) {//将查询到的部门加入到ids中待查寻它的子部门
                    ids.add(node.getDeptId());
                }
            }
        }
        return TreeUtils.listToTree(departments, new DepartmentTreeNodeMapper(root));
    }


    //获取部门列表
    @Override
    public List<QueryDepartmentTreeVO> getDepartmentList(DepartmentQuery query) {

        return new ArrayList<QueryDepartmentTreeVO>();
        
//        //构建列表查询对象(DO)
//        List<Department> page = new ArrayList<>();
//        //构建查询条件
//        QueryWrapper<Department> queryWrapper = new QueryWrapper<>();
//        //如果存在合法参数则添加条件
//        if (query.getDeptName() != null) queryWrapper.like("dept_name", query.getDeptName());
//        if (query.getOrderNum() >= 0) queryWrapper.eq("order_num", query.getOrderNum());
//        if (query.getStatus() >= 0) queryWrapper.eq("status", query.getStatus());
//        if (query.getCreateTime() != null) queryWrapper.eq("create_by", query.getCreateTime());
////        //执行查询
////        Page<Department> res = baseMapper.selectPage(page, queryWrapper);
////        //将结果转化为DTO
////        if (res == null) return null;//result为空表示查询失败
////        return PageDTO.create(res, msDepartmentMapper::departmentOToDepartmentDTO);
    }

    //根据id获取指定部门所有信息
    @Override
    public DepartmentDTO getDepartmentDetail(int id) {
        //执行查询
        Department department = baseMapper.selectById(id);
        if (department != null) {
            return msDepartmentMapper.departmentOToDepartmentDTO(department);
        }
        return null;//null表示查询失败没有该条数据
    }

    @Override
    public int saveDepartment(DepartmentDTO departmentDTO) {
        Department department = msDepartmentMapper.departmentDTOToDepartment(departmentDTO);
        department.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(department);
    }

    @Override
    public int updateDepartment(DepartmentDTO departmentDTO) {
        Department department = msDepartmentMapper.departmentDTOToDepartment(departmentDTO);
        department.setUpdateTime(LocalDateTime.now());
        return baseMapper.updateById(department);
    }

    @Override
    public int removeDepartment(int id) {
        return baseMapper.deleteById(id);

    }
}

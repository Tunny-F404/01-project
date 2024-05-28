package com.zeroone.star.orgstructure.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zeroone.star.orgstructure.mapper.DeptMapper;
import com.zeroone.star.orgstructure.mapper.UserMapper;
import com.zeroone.star.project.j1.orgstructure.dto.user.UserDTO;
import com.zeroone.star.project.j1.orgstructure.entity.SysDeptDO;
import com.zeroone.star.project.j1.orgstructure.entity.SysUserDO;
import com.zeroone.star.project.j1.orgstructure.query.user.UserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DeptMapper deptMapper;

    public List<UserDTO> queryUserList(UserQuery userQuery)
    {
        List<SysUserDO> sysUserDOS = null;
        //日期全局转换格式
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //构建分页对象
        IPage<SysUserDO> page = new Page<>(userQuery.getPageIndex(), userQuery.getPageSize());

        //构建用户表wrapper对象
        QueryWrapper<SysUserDO> queryWrapper = new QueryWrapper<>();

        //将query对象所有属性插入 使用lambda，避免字符串魔法值
        if(userQuery.getStatus() != null)
        {
            queryWrapper.lambda().eq(SysUserDO::getStatus, userQuery.getStatus());//用户状态精确查询
        }
        if(userQuery.getUserName() != null)
        {
            queryWrapper.lambda().like(SysUserDO::getUserName, userQuery.getUserName());//用户名称模糊查询
        }
        if(userQuery.getPhonenumber() != null)
        {
            queryWrapper.lambda().like(SysUserDO::getPhonenumber, userQuery.getPhonenumber());//用户电话模糊查询
        }
        //判断创建时间和结束时间是否为空
        if(userQuery.getBeginDate() != null && userQuery.getEndDate() != null)
        {
            //将userQuery的String日期转换为LocalDatetime类型
            LocalDateTime begin = LocalDateTime.parse(userQuery.getBeginDate() + " 00:00:00", dtf);
            LocalDateTime end = LocalDateTime.parse(userQuery.getEndDate() + " 23:59:59", dtf);

            queryWrapper.lambda().between(SysUserDO::getCreateTime, begin, end);//用户创建时间范围查询
        }
        //判断部门名称是否为空
        if (userQuery.getDept() != null)
        {
            //构建部门的wrapper 通过部门名称查询部门DO实体
            QueryWrapper<SysDeptDO> deptDOQueryWrapper = new QueryWrapper<>();
            deptDOQueryWrapper.lambda().eq(SysDeptDO::getDeptName, userQuery.getDept());
            SysDeptDO deptDO = deptMapper.selectOne(deptDOQueryWrapper);

            queryWrapper.lambda().eq(SysUserDO::getDeptId, deptDO.getDeptId());//用户部门id精确查询
        }

        userMapper.selectPage(page, queryWrapper);
        sysUserDOS = page.getRecords();

        List<UserDTO> userDTOS = new ArrayList<>();
        for(int i = 0; i < sysUserDOS.size(); i++)
        {
            UserDTO userDTO = new UserDTO();
            userDTO.setPageIndex(userQuery.getPageIndex());
            userDTO.setPageSize(userQuery.getPageSize());

            userDTO.setUserId(sysUserDOS.get(i).getUserId());
            userDTO.setUserName(sysUserDOS.get(i).getUserName());
            userDTO.setNickName(sysUserDOS.get(i).getNickName());

            //设置部门名称
            SysDeptDO deptDO = deptMapper.selectById(sysUserDOS.get(i).getDeptId());
            if(deptDO != null)
            {
                userDTO.setDept(deptDO.getDeptName());
            }

            userDTO.setPhonenumber(sysUserDOS.get(i).getPhonenumber());
            userDTO.setStatus(sysUserDOS.get(i).getStatus());
            userDTO.setCreateTime(sysUserDOS.get(i).getCreateTime().format(dtf));
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }
}

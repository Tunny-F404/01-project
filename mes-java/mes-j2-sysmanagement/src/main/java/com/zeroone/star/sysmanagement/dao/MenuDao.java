package com.zeroone.star.sysmanagement.dao;

import com.zeroone.star.project.j2.sysmanagement.dto.menu.MenuDTO;
import com.zeroone.star.project.j2.sysmanagement.query.menu.MenuQuery;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface MenuDao {

    //新增菜单
    @Insert("insert into sys_menu values(#{menu_id},#{menu_name},#{parent_id},#{order_num},#{path},#{component},#{query},#{is_frame},#{is_cache},#{menu_type},#{visible},#{status},#{perms},#{icon},#{create_by},#{create_time},#{update_by},#{update_time},#{remark})")
    public void addMenu(MenuDTO menuDTO);

    //修改资源
    @Update("update sys_menu " +
            "set menu_name=#{menu_name},icon=#{icon},is_cache=#{is_cache},visible=#{visible},create_time")
    public void modifyMenu(MenuDTO menuDTO);

    //删除资源
    @Delete("delete from sys_menu where menu_id=#{menu_id}")
    public void removeMenu(MenuQuery menu_id);


}

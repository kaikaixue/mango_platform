package com.xkk.mango.admin.dao;

import com.xkk.mango.admin.model.SysMenu;
import lombok.extern.java.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SysMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    int updateByPrimaryKeySelective(SysMenu record);

    SysMenu selectByPrimaryKey(Long id);

    List<SysMenu> selectAll();

    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> findRoleMenus(@Param(value = "roleId") Long roleId);

    List<SysMenu> findByUserName(@Param(value = "userName") String userName);
}
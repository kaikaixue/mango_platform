package com.xkk.mango.admin.dao;

import com.xkk.mango.admin.model.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysRoleMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    SysRoleMenu selectByPrimaryKey(Long id);

    List<SysRoleMenu> selectAll();

    int updateByPrimaryKey(SysRoleMenu record);

    int deleteByRoleId(Long roleId);
}
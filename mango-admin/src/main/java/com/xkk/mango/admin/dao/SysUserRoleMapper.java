package com.xkk.mango.admin.dao;

import com.xkk.mango.admin.model.SysUser;
import com.xkk.mango.admin.model.SysUserRole;
import lombok.extern.java.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SysUserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Long id);

    List<SysUserRole> selectAll();

    int updateByPrimaryKey(SysUserRole record);

    int updateByPrimaryKeySelective(SysUserRole record);

    List<SysUserRole> findUserRoles(@Param(value = "userId") Long userId);
}
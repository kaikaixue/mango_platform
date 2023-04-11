package com.xkk.mango.admin.dao;

import com.xkk.mango.admin.model.SysRoleDept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysRoleDeptMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleDept record);

    SysRoleDept selectByPrimaryKey(Long id);

    List<SysRoleDept> selectAll();

    int updateByPrimaryKey(SysRoleDept record);
}
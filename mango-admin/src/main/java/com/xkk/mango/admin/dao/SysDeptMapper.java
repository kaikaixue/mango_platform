package com.xkk.mango.admin.dao;

import com.xkk.mango.admin.model.SysDept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysDeptMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysDept record);

    int insertSelective(SysDept record);

    SysDept selectByPrimaryKey(Long id);

    List<SysDept> selectAll();

    int updateByPrimaryKey(SysDept record);
}
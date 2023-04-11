package com.xkk.mango.admin.dao;

import com.xkk.mango.admin.model.SysConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysConfigMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysConfig record);

    int insertSelective(SysConfig record);

    SysConfig selectByPrimaryKey(Long id);

    List<SysConfig> selectAll();

    int updateByPrimaryKey(SysConfig record);

    int updateByPrimaryKeySelective(SysConfig record);

    List<SysConfig> findByLabel(String label);

    List<SysConfig> findPageByLabel(@Param(value = "label") String label);
}
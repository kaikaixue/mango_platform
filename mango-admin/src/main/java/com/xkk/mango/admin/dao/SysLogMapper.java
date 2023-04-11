package com.xkk.mango.admin.dao;

import com.xkk.mango.admin.model.SysLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(Long id);

    List<SysLog> selectAll();

    int updateByPrimaryKey(SysLog record);

    int updateByPrimaryKeySelective(SysLog record);

    List<SysLog> findPageByUserName(String label);
}
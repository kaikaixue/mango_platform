package com.xkk.mango.admin.dao;

import com.xkk.mango.admin.model.SysLoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SysLoginLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysLoginLog record);

    int insertSelective(SysLoginLog record);

    SysLoginLog selectByPrimaryKey(Long id);

    List<SysLoginLog> selectAll();

    int updateByPrimaryKey(SysLoginLog record);

    int updateByPrimaryKeySelective(SysLoginLog record);

    List<SysLoginLog> findPageByUserName(@Param(value = "userName") String userName);

    List<SysLoginLog> findPageByStatus(@Param(value = "status") String status);
}
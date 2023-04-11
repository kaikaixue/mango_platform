package com.xkk.mango.admin.dao;

import com.xkk.mango.admin.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser sysUser);

    SysUser selectByPrimaryKey(Long id);

    List<SysUser> findAll();

    SysUser findByName(@Param(value = "name") String name);

    int updateByPrimaryKey(SysUser record);

    /**
     * 分页查询
     * @return
     */
    List<SysUser> findPage();

    List<SysUser> findPageByNameAndEmail(String name, String email);

    List<SysUser> findPageByName(String name);
}
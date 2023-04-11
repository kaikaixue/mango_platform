package com.xkk.mango.admin.dao;

import com.xkk.mango.admin.model.SysDict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SysDictMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysDict record);

    int insertSelective(SysDict record);

    SysDict selectByPrimaryKey(Long id);

    List<SysDict> selectAll();

    int updateByPrimaryKey(SysDict record);

    /**
     * 分页查询
     * @return
     */
    List<SysDict> findPage();

    /**
     * 根据标签名称查询
     * @param label
     * @return
     */
    List<SysDict> findByLabel(@Param(value="label") String label);

    /**
     * 根据标签名称分页查询
     * @param label
     * @return
     */
    List<SysDict> findPageByLabel(@Param(value = "label") String label);
}
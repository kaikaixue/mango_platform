package com.xkk.mango.admin.service.impl;

import com.xkk.mango.admin.constant.SysConstants;
import com.xkk.mango.admin.dao.SysMenuMapper;
import com.xkk.mango.admin.dao.SysRoleMapper;
import com.xkk.mango.admin.dao.SysRoleMenuMapper;
import com.xkk.mango.admin.model.SysMenu;
import com.xkk.mango.admin.model.SysRole;
import com.xkk.mango.admin.model.SysRoleMenu;
import com.xkk.mango.admin.service.SysRoleService;
import com.xkk.mango.core.page.MybatisPageHelper;
import com.xkk.mango.core.page.PageRequest;
import com.xkk.mango.core.page.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    SysRoleMapper sysRoleMapper;
    @Resource
    SysMenuMapper sysMenuMapper;
    @Resource
    SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public int save(SysRole record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysRoleMapper.insertSelective(record);
        }
        return sysRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysRole record) {
        return sysRoleMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysRole> records) {
        for (SysRole record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysRole findById(Long id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParam("name");
        if (label != null) {
            return MybatisPageHelper.findPage(pageRequest, sysRoleMapper, "findPageByName", label);
        }
        return MybatisPageHelper.findPage(pageRequest, sysRoleMapper);
    }

    @Override
    public List<SysRole> findAll() {
        return sysRoleMapper.selectAll();
    }

    @Override
    public List<SysMenu> findRoleMenus(Long roleId) {
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(roleId);
        if (sysRole.getName().equals(SysConstants.ADMIN)) {
            // 超级管理员返回全部
            return sysMenuMapper.selectAll();
        }
        return sysMenuMapper.findRoleMenus(roleId);
    }

    @Transactional
    @Override
    public int saveRoleMenus(List<SysRoleMenu> records) {
        if (records == null || records.isEmpty()) {
            return 1;
        }
        Long roleId = records.get(0).getRoleId();
        sysRoleMenuMapper.deleteByRoleId(roleId);
        for (SysRoleMenu record : records) {
            sysRoleMenuMapper.insertSelective(record);
        }
        return 1;
    }
}

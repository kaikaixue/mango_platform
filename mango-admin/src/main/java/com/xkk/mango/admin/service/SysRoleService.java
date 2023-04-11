package com.xkk.mango.admin.service;

import com.xkk.mango.admin.model.SysMenu;
import com.xkk.mango.admin.model.SysRole;
import com.xkk.mango.admin.model.SysRoleMenu;
import com.xkk.mango.core.service.CurdService;

import java.util.List;

public interface SysRoleService extends CurdService<SysRole> {
    List<SysRole> findAll();
    List<SysMenu> findRoleMenus(Long roleId);
    int saveRoleMenus(List<SysRoleMenu> records);
}

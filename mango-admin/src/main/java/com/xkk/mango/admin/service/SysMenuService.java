package com.xkk.mango.admin.service;

import com.xkk.mango.admin.model.SysMenu;
import com.xkk.mango.core.service.CurdService;

import java.util.List;

public interface SysMenuService extends CurdService<SysMenu> {
    List<SysMenu> findAll();
    List<SysMenu> findTree(String userName, int menuType);
    List<SysMenu> findByUser(String userName);
}

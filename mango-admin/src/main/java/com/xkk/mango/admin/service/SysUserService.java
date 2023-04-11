package com.xkk.mango.admin.service;

import com.xkk.mango.admin.model.SysUser;
import com.xkk.mango.admin.model.SysUserRole;
import com.xkk.mango.core.page.PageRequest;
import com.xkk.mango.core.service.CurdService;

import java.io.File;
import java.util.List;
import java.util.Set;

public interface SysUserService extends CurdService<SysUser> {
    List<SysUser> findAll();

    SysUser findByName(String name);

    /**
     * 生成用户信息的Excel文件
     * @param pageRequest
     * @return
     */
    File createUserExcelFile (PageRequest pageRequest);

    /**
     * 查询用户权限
     * @param userId
     * @return
     */
    List<SysUserRole> findUserRoles(Long userId);

    /**
     * 查找用户的菜单权限标识集合
     * @param userName
     * @return
     */
    Set<String> findPermissions(String userName);
}

package com.xkk.mango.admin.controller;

import com.xkk.mango.admin.model.SysRole;
import com.xkk.mango.admin.model.SysRoleMenu;
import com.xkk.mango.admin.service.SysRoleService;
import com.xkk.mango.core.http.HttpResult;
import com.xkk.mango.core.page.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/role")
public class SysRoleController {
    @Resource
    SysRoleService sysRoleService;

    @PostMapping("/save")
    public HttpResult save(@RequestBody SysRole record) {
        return HttpResult.ok(sysRoleService.save(record));
    }

    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysRole> records) {
        return HttpResult.ok(sysRoleService.delete(records));
    }

    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysRoleService.findPage(pageRequest));
    }

    @PostMapping("/findAll")
    public HttpResult findAll() {
        return HttpResult.ok(sysRoleService.findAll());
    }

    /**
     * 查询角色菜单
     * @param roleId
     * @return
     */
    @PostMapping("/findRoleMenus")
    public HttpResult findRoleMenus(Long roleId) {
        return HttpResult.ok(sysRoleService.findRoleMenus(roleId));
    }

    /**
     * 保存角色菜单
     * @param records
     * @return
     */
    @PostMapping("/saveRoleMenus")
    public HttpResult saveRoleMenus(List<SysRoleMenu> records) {
        return HttpResult.ok();
    }
}

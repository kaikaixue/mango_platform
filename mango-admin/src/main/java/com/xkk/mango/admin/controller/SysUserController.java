package com.xkk.mango.admin.controller;

import com.xkk.mango.admin.model.SysUser;
import com.xkk.mango.admin.service.SysUserService;
import com.xkk.mango.common.utils.FileUtils;
import com.xkk.mango.core.http.HttpResult;
import com.xkk.mango.core.page.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

@RestController
@RequestMapping("/user")
public class SysUserController {
    @Resource
    SysUserService sysUserService;

    @PostMapping("/save")
    public HttpResult save(@RequestBody SysUser record) {
        return HttpResult.ok(sysUserService.save(record));
    }

    @PostMapping("/findByName")
    public HttpResult findByName(@RequestBody String name) {
        return HttpResult.ok(sysUserService.findByName(name));
    }

    @GetMapping("/findAll")
    public Object findAll() {
        return sysUserService.findAll();
    }

    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysUserService.findPage(pageRequest));
    }

    /**
     * 查询用户权限
     * @param name
     * @return
     */
    @PostMapping("/findPermissions")
    public HttpResult findPermissions(@RequestBody String name) {
        return HttpResult.ok();
    }

    /**
     * 查询用户角色
     * @param userId
     * @return
     */
    @PostMapping("/findUserRoles")
    public HttpResult findUserRoles(@RequestBody Long userId) {
        return HttpResult.ok();
    }

    @PostMapping("/exportExcelUser")
    public void exportExcelUser(@RequestBody PageRequest pageRequest, HttpServletResponse res) {
        File file = sysUserService.createUserExcelFile(pageRequest);
        FileUtils.downloadFile(res, file, file.getName());
    }
}

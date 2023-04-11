package com.xkk.mango.admin.controller;

import com.xkk.mango.admin.model.SysMenu;
import com.xkk.mango.admin.service.SysMenuService;
import com.xkk.mango.core.http.HttpResult;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/menu")
public class SysMenuController {
    @Resource
    SysMenuService sysMenuService;

    @PostMapping("/save")
    public HttpResult save(@RequestBody SysMenu record) {
        return HttpResult.ok(sysMenuService.save(record));
    }

    @PostMapping("/delete")
    public HttpResult delete(@RequestBody SysMenu record) {
        return HttpResult.ok(sysMenuService.delete(record));
    }

    /**
     * 查询导航菜单树
     * @param userName
     * @return
     */
    @GetMapping("/findNavTree")
    public HttpResult findNavTree(@RequestParam String userName) {
        return HttpResult.ok(sysMenuService.findTree(userName, 1));
    }

    @GetMapping("/findMenuTree")
    public HttpResult findMenuTree() {
        return HttpResult.ok(sysMenuService.findTree(null,  0));
    }
}

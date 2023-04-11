package com.xkk.mango.admin.controller;

import com.xkk.mango.admin.model.SysDept;
import com.xkk.mango.admin.service.SysDeptService;
import com.xkk.mango.core.http.HttpResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/dept")
public class SysDeptController {
    @Resource
    SysDeptService sysDeptService;

    @PostMapping("/save")
    public HttpResult save(@RequestBody SysDept record) {
        return HttpResult.ok(sysDeptService.save(record));
    }

    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysDept> records) {
        return HttpResult.ok(sysDeptService.delete(records));
    }

    /**
     * 查询机构树
     * @return
     */
    @PostMapping("/findTree")
    public HttpResult findTree() {
        return HttpResult.ok(sysDeptService.findTree());
    }
}

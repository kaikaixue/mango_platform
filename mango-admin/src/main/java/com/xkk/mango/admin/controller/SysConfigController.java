package com.xkk.mango.admin.controller;

import com.xkk.mango.admin.model.SysConfig;
import com.xkk.mango.admin.service.SysConfigService;
import com.xkk.mango.core.http.HttpResult;
import com.xkk.mango.core.page.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/config")
public class SysConfigController {
    @Resource
    SysConfigService sysConfigService;

    @PostMapping("/save")
    public HttpResult save(@RequestBody SysConfig record) {
        return HttpResult.ok(sysConfigService.save(record));
    }

    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysConfig> records) {
        return HttpResult.ok(sysConfigService.delete(records));
    }

    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysConfigService.findPage(pageRequest));
    }

    @GetMapping("/findByLabel")
    public HttpResult findByLabel(@RequestParam String label) {
        return HttpResult.ok(sysConfigService.findByLabel(label));
    }
}

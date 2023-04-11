package com.xkk.mango.admin.controller;

import com.xkk.mango.admin.model.SysLog;
import com.xkk.mango.admin.service.SysLogService;
import com.xkk.mango.core.http.HttpResult;
import com.xkk.mango.core.page.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/log")
public class SysLogController {
    @Resource
    SysLogService sysLogService;

    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysLogService.findPage(pageRequest));
    }

    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysLog> records) {
        return HttpResult.ok(sysLogService.delete(records));
    }
}

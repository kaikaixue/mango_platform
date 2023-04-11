package com.xkk.mango.admin.controller;

import com.xkk.mango.admin.model.SysLoginLog;
import com.xkk.mango.admin.service.SysLoginLogService;
import com.xkk.mango.core.http.HttpResult;
import com.xkk.mango.core.page.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 登录日志管理
 */
@RestController
@RequestMapping("/loginlog")
public class SysLoginLogController {
    @Resource
    SysLoginLogService sysLoginLogService;

    /**
     * 分页查询
     * @param pageRequest
     * @return
     */
    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysLoginLogService.findPage(pageRequest));
    }

    /**
     * 删除登录日志
     * @param records
     * @return
     */
    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysLoginLog> records) {
        return HttpResult.ok(sysLoginLogService.delete(records));
    }
}

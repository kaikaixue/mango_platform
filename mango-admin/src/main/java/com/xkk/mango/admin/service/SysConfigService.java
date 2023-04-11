package com.xkk.mango.admin.service;

import com.xkk.mango.admin.model.SysConfig;
import com.xkk.mango.core.service.CurdService;

import java.util.List;

public interface SysConfigService extends CurdService<SysConfig> {
    List<SysConfig> findByLabel(String label);
}

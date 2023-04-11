package com.xkk.mango.admin.service;

import com.xkk.mango.admin.model.SysDict;
import com.xkk.mango.core.service.CurdService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典管理
 */
public interface SysDictService extends CurdService<SysDict> {
    /**
     * 根据名称查询
     * @param label
     * @return
     */
    List<SysDict> findByLabel(String label);
}

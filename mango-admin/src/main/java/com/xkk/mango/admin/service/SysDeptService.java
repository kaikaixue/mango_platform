package com.xkk.mango.admin.service;

import com.xkk.mango.admin.model.SysDept;
import com.xkk.mango.core.service.CurdService;

import java.util.List;

public interface SysDeptService extends CurdService<SysDept> {
    public List<SysDept> findTree();
}

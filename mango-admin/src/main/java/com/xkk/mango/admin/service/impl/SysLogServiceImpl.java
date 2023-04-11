package com.xkk.mango.admin.service.impl;

import com.xkk.mango.admin.dao.SysLogMapper;
import com.xkk.mango.admin.model.SysLog;
import com.xkk.mango.admin.service.SysLogService;
import com.xkk.mango.core.page.MybatisPageHelper;
import com.xkk.mango.core.page.PageRequest;
import com.xkk.mango.core.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Resource
    SysLogMapper sysLogMapper;

    @Override
    public int save(SysLog record) {
        if(record.getId() == null || record.getId() == 0) {
            return sysLogMapper.insertSelective(record);
        }
        return sysLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysLog record) {
        return sysLogMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysLog> records) {
        for(SysLog record:records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysLog findById(Long id) {
        return sysLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParam("userName");
        if (label != null) {
            return MybatisPageHelper.findPage(pageRequest, sysLogMapper, "findPageByUserName", label);
        }
        return MybatisPageHelper.findPage(pageRequest, sysLogMapper);
    }
}

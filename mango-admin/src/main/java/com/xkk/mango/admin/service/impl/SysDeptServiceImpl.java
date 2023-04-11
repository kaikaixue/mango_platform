package com.xkk.mango.admin.service.impl;

import com.xkk.mango.admin.dao.SysDeptMapper;
import com.xkk.mango.admin.model.SysDept;
import com.xkk.mango.admin.service.SysDeptService;
import com.xkk.mango.core.page.MybatisPageHelper;
import com.xkk.mango.core.page.PageRequest;
import com.xkk.mango.core.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysDeptServiceImpl implements SysDeptService {

    @Resource
    SysDeptMapper sysDeptMapper;

    @Override
    public int save(SysDept record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysDeptMapper.insertSelective(record);
        }
        return sysDeptMapper.updateByPrimaryKey(record);
    }

    @Override
    public int delete(SysDept record) {
        return sysDeptMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysDept> records) {
        for (SysDept record:records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysDept findById(Long id) {
        return sysDeptMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, sysDeptMapper);
    }

    @Override
    public List<SysDept> findTree() {
        List<SysDept> sysDepts = new ArrayList<>();
        List<SysDept> depts = sysDeptMapper.selectAll();
        for (SysDept dept:depts) {
            if (dept.getParentId() == null || dept.getParentId() == 0) {
                dept.setLevel(0);
                sysDepts.add(dept);
            }
        }
        findChildren(sysDepts, depts);
        return sysDepts;
    }

    private void findChildren(List<SysDept> sysDepts, List<SysDept> depts) {
        for (SysDept sysDept: sysDepts) {
            List<SysDept> children = new ArrayList<>();
            for (SysDept dept:depts) {
                if (sysDept.getId() != null && sysDept.getId().equals(dept.getParentId())) {
                    dept.setParentName(sysDept.getName());
                    dept.setLevel(sysDept.getLevel() + 1);
                    children.add(dept);
                }
            }
            sysDept.setChildren(children);
            findChildren(children, depts);
        }
    }
}

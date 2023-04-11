package com.xkk.mango.admin.service.impl;

import com.xkk.mango.admin.constant.SysConstants;
import com.xkk.mango.admin.dao.SysMenuMapper;
import com.xkk.mango.admin.model.SysMenu;
import com.xkk.mango.admin.service.SysMenuService;
import com.xkk.mango.core.page.PageRequest;
import com.xkk.mango.core.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Resource
    SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> findAll() {
        return sysMenuMapper.selectAll();
    }

    @Override
    public List<SysMenu> findTree(String userName, int menuType) {
        List<SysMenu> sysMenus = new ArrayList<>();
        List<SysMenu> menus = findByUser(userName);
        for (SysMenu menu : menus) {
            if (menu.getParentId() == null || menu.getParentId() == 0) {
                menu.setLevel(0);
                if (!exists(sysMenus, menu)) {
                    sysMenus.add(menu);
                }
            }
        }
//        sysMenus.sort((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
        findChildren(sysMenus, menus, menuType);
        return sysMenus;
    }

    private void findChildren(List<SysMenu> sysMenus, List<SysMenu> menus, int menuType) {
        for (SysMenu sysMenu : sysMenus) {
            List<SysMenu> children = new ArrayList<>();
            for (SysMenu menu : menus) {
                if (menuType == 1 && menu.getType() == 2) {
                    // 如果是获取类型不需要按钮，且菜单类型是按钮的，直接过滤掉
                    continue;
                }
                if (sysMenu.getId() != null && sysMenu.getId().equals(menu.getParentId())) {
                    menu.setParentName(sysMenu.getName());
                    menu.setLevel(sysMenu.getLevel() + 1);
                    if (!exists(children, menu)) {
                        children.add(menu);
                    }
                }
            }
            sysMenu.setChildren(children);
//            children.sort(((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum())));
            findChildren(children, menus, menuType);
        }
    }

    private boolean exists(List<SysMenu> sysMenus, SysMenu sysMenu) {
        boolean exist = false;
        for (SysMenu menu : sysMenus) {
            if (menu.getId().equals(sysMenu.getId())) {
                exist = true;
            }
        }
        return exist;
    }

    @Override
    public List<SysMenu> findByUser(String userName) {
        if (userName == null || "".equals(userName) || SysConstants.ADMIN.equals(userName)) {
            return sysMenuMapper.selectAll();
        }
        return sysMenuMapper.findByUserName(userName);
    }


    @Override
    public int save(SysMenu record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysMenuMapper.insertSelective(record);
        }
        return sysMenuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysMenu record) {
        return sysMenuMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysMenu> records) {
        return 0;
    }

    @Override
    public SysMenu findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return null;
    }
}

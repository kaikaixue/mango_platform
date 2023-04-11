package com.xkk.mango.core.page;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 分页请求
 */
@Data
public class PageRequest {
    /**
     * 当前页码
     */
    private int pageNum = 1;

    /**
     * 每页数量
     */
    private int pageSize = 10;

    /**
     * 查询参数
     */
    private Map<String, Object> params = new HashMap<>();

    /**
     * 获取key的值
     * @param key
     * @return
     */
    public Object getParam(String key) {
        return getParams().get(key);
    }
}

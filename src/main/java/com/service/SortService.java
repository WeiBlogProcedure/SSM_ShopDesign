package com.service;

import com.entity.Sort;

import java.util.List;

public interface SortService {
    /**
     * 获取分类列表
     * @param where
     * @return
     */
    List<Sort> list(String where);

    /**
     * 分页
     * @param where
     * @return
     */
    List<Sort> sealist(String where);

    /**
     * 统计
     * @return
     */
    int total();

    /**
     * 新增分类
     * @param sort
     */
    void insert(Sort sort);

    /**
     * 删除分类
     * @param sort
     */
    void delete(Sort sort);

    /**
     * 修改分类信息
     * @param sort
     */
    void update(Sort sort);

    /**
     * 根据id获取分类信息
     * @param id
     * @return
     */
    Sort get(int id);

    /**
     *
     * @param value
     */
    void updatesql(String value);

    /**
     *
     * @param value
     */
    void deletesql(String value);
}

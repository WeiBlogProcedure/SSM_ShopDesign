package com.service;


import com.entity.Store;

import java.util.List;

public interface StoreService {
    /**
     * 门店信息列表
     * @param where
     * @return
     */
    List<Store> list(String where);

    /**
     * 分页
     * @param where
     * @return
     */
    List<Store> sealist(String where);

    /**
     * 统计
     * @return
     */
    int total();

    /**
     * 新增门店
     * @param store
     */
    void insert(Store store);

    /**
     * 删除门店
     * @param store
     */
    void delete(Store store);

    /**
     * 更新门店信息
     * @param store
     */
    void update(Store store);

    /**
     * 根据id获取门店信息
     * @param id
     * @return
     */
    Store get(int id);

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

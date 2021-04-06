package com.service;

import com.entity.Transfer;

import java.util.List;

public interface TransferService {
    /**
     * 调货信息列表
     * @param where
     * @return
     */
    List<Transfer> list(String where);

    /**
     * 分页
     * @param where
     * @return
     */
    List<Transfer> sealist(String where);

    /**
     * 统计
     * @return
     */
    int total();

    /**
     * 新增调货单
     * @param transfer
     */
    void insert(Transfer transfer);

    /**
     * 删除调货单
     * @param transfer
     */
    void delete(Transfer transfer);

    /**
     * 更新调货单信息
     * @param transfer
     */
    void update(Transfer transfer);

    /**
     * 根据id获取调货单信息
     * @param id
     * @return
     */
    Transfer get(int id);

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

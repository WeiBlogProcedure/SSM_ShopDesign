package com.service;

import com.entity.ReturnGoods;

import java.util.List;

public interface ReturnGoodsService {
    /**
     * 打印退货单列表
     * @param where
     * @return
     */
    List<ReturnGoods> list(String where);

    /**
     * 分页
     * @param where
     * @return
     */
    List<ReturnGoods> sealist(String where);

    /**
     * 统计
     * @return
     */
    int total();

    /**
     * 新增退货单
     * @param returnGoods
     */
    void insert(ReturnGoods returnGoods);

    /**
     * 删除退货单
     * @param returnGoods
     */
    void delete(ReturnGoods returnGoods);

    /**
     * 更新退货单
     * @param returnGoods
     */
    void update(ReturnGoods returnGoods);

    /**
     * 根据id查询退货单信息
     * @param id
     * @return
     */
    ReturnGoods get(int id);

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

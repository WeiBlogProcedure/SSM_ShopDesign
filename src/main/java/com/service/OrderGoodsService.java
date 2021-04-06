package com.service;

import com.entity.OrderGoods;

import java.util.List;

public interface OrderGoodsService {
    /**
     * 订货单列表
     * @param where
     * @return
     */
    List<OrderGoods> list(String where);

    /**
     * 分页
     * @param where
     * @return
     */
    List<OrderGoods> sealist(String where);

    /**
     * 统计
     * @return
     */
    int total();

    /**
     * 新增订货单
     * @param orderGoods
     */
    void insert(OrderGoods orderGoods);

    /**
     * 删除订货单
     * @param orderGoods
     */
    void delete(OrderGoods orderGoods);

    /**
     * 更新订单
     * @param orderGoods
     */
    void update(OrderGoods orderGoods);

    /**
     * 根据id查询订单
     * @param id
     * @return
     */
    OrderGoods get(int id);

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

package com.service.Impl;

import com.entity.OrderGoods;
import com.mapper.OrderGoodsMapper;
import com.service.OrderGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderGoodsServiceImpl implements OrderGoodsService {
    @Autowired
    OrderGoodsMapper orderGoodsMapper;

    @Override
    public List<OrderGoods> list(String where) {
        return orderGoodsMapper.list(where);
    }

    @Override
    public List<OrderGoods> sealist(String where) {
        return orderGoodsMapper.sealist(where);
    }

    @Override
    public int total() {
        return orderGoodsMapper.total();
    }

    @Override
    public void insert(OrderGoods c) {
        orderGoodsMapper.insert(c);
    }

    @Override
    public void update(OrderGoods c) {
        orderGoodsMapper.update(c);
    }

    @Override
    public void delete(OrderGoods c) {
        orderGoodsMapper.delete(c.getId());
    }

    @Override
    public OrderGoods get(int id) {
        return orderGoodsMapper.get(id);
    }

    @Override
    public void updatesql(String value) {
        orderGoodsMapper.updatesql(value);
    }

    @Override
    public void deletesql(String value) {
        orderGoodsMapper.deletesql(value);
    }
}

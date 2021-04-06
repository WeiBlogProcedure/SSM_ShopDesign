package com.service.Impl;

import com.entity.ReturnGoods;
import com.mapper.ReturnGoodsMapper;
import com.service.ReturnGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnGoodsServiceImpl implements ReturnGoodsService {
    @Autowired
    ReturnGoodsMapper returnGoodsMapper;

    @Override
    public List<ReturnGoods> list(String where) {
        return returnGoodsMapper.list(where);
    }

    @Override
    public List<ReturnGoods> sealist(String where) {
        return returnGoodsMapper.sealist(where);
    }

    @Override
    public int total() {
        return returnGoodsMapper.total();
    }

    @Override
    public void insert(ReturnGoods c) {
        returnGoodsMapper.insert(c);

    }

    @Override
    public void update(ReturnGoods c) {
        returnGoodsMapper.update(c);
    }

    @Override
    public void delete(ReturnGoods c) {
        returnGoodsMapper.delete(c.getId());
    }

    @Override
    public ReturnGoods get(int id) {
        return returnGoodsMapper.get(id);
    }

    @Override
    public void updatesql(String value) {
        returnGoodsMapper.updatesql(value);
    }

    @Override
    public void deletesql(String value) {
        returnGoodsMapper.deletesql(value);
    }
}

package com.service.Impl;

import com.entity.Store;
import com.mapper.StoreMapper;
import com.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    StoreMapper storeMapper;

    @Override
    public List<Store> list(String where){
        return storeMapper.list(where);
    }

    @Override
    public List<Store> sealist(String where) {
        return storeMapper.sealist(where);
    }

    @Override
    public int total() {
        return storeMapper.total();
    }

    @Override
    public void insert(Store c) {
        storeMapper.insert(c);
    }

    @Override
    public void update(Store c) {
        storeMapper.update(c);
    }

    @Override
    public void delete(Store c) {
        storeMapper.delete(c.getId());
    }

    @Override
    public Store get(int id) {
        return storeMapper.get(id);
    }

    @Override
    public void updatesql(String value) {
        storeMapper.updatesql(value);
    }

    @Override
    public void deletesql(String value) {
        storeMapper.deletesql(value);
    }
}

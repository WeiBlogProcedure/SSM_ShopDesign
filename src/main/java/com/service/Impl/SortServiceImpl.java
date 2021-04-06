package com.service.Impl;

import com.entity.Sort;
import com.mapper.SortMapper;
import com.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortServiceImpl implements SortService {
    @Autowired
    SortMapper sortMapper;

    @Override
    public List<Sort> list(String where) {
        return sortMapper.list(where);
    }

    @Override
    public List<Sort> sealist(String where) {
        return sortMapper.sealist(where);
    }

    @Override
    public int total() {
        return sortMapper.total();
    }

    @Override
    public void insert(Sort c) {
        sortMapper.insert(c);
    }

    @Override
    public void update(Sort c) {
        sortMapper.update(c);
    }

    @Override
    public void delete(Sort c) {
        sortMapper.delete(c.getId());
    }

    @Override
    public Sort get(int id) {
        return sortMapper.get(id);
    }

    @Override
    public void updatesql(String value) {
        sortMapper.updatesql(value);
    }

    @Override
    public void deletesql(String value) {
        sortMapper.deletesql(value);
    }
}

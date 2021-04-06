package com.service.Impl;

import com.entity.Transfer;
import com.mapper.TransferMapper;
import com.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {
    @Autowired
    TransferMapper transferMapper;

    @Override
    public List<Transfer> list(String where) {
        return transferMapper.list(where);
    }

    @Override
    public List<Transfer> sealist(String where) {
        return transferMapper.sealist(where);
    }

    @Override
    public int total() {
        return transferMapper.total();
    }

    @Override
    public void insert(Transfer c) {
        transferMapper.insert(c);
    }

    @Override
    public void update(Transfer c) {
        transferMapper.update(c);
    }

    @Override
    public void delete(Transfer c) {
        transferMapper.delete(c.getId());
    }

    @Override
    public Transfer get(int id) {
        return transferMapper.get(id);
    }

    @Override
    public void updatesql(String value) {
        transferMapper.updatesql(value);
    }

    @Override
    public void deletesql(String value) {
        transferMapper.deletesql(value);
    }
}

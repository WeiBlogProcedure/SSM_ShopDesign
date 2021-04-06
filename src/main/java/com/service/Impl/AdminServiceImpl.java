package com.service.Impl;

import com.entity.Admin;
import com.mapper.AdminMapper;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public List<Admin> list(String where) {
        return adminMapper.list(where);
    }

    @Override
    public List<Admin> sealist(String where) {
        return adminMapper.sealist(where);
    }

    @Override
    public int total() {
        return adminMapper.total();
    }

    @Override
    public void insert(Admin admin) {
        adminMapper.insert(admin);
    }

    @Override
    public void delete(Admin admin) {
        adminMapper.delete(admin.getId());
    }

    @Override
    public void update(Admin admin) {
        adminMapper.update(admin);
    }

    @Override
    public Admin get(int id) {
        return adminMapper.get(id);
    }
}

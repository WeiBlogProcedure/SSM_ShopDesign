package com.service.Impl;

import com.entity.User;
import com.mapper.UserMapper;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> list(String where) {
        return userMapper.list(where);
    }

    @Override
    public List<User> sealist(String where) {
        return userMapper.sealist(where);
    }

    @Override
    public int total() {
        return userMapper.total();
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void delete(User user) {
        userMapper.delete(user.getId());
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public User get(int id) {
        return userMapper.get(id);
    }

    @Override
    public void updatesql(String value) {
        userMapper.updatesql(value);
    }

    @Override
    public void deletesql(String value) {
        userMapper.deletesql(value);
    }
}

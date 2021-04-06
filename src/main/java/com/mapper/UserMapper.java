package com.mapper;

import com.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //添加
    int insert(User user);
    //删除
    void delete(int id);
    //根据id获取数据
    User get(int id);
    //修改
    int update(User user);
    //列表
    List<User> list(@Param("where") String where);
    //分页
    List<User> sealist(@Param("where") String where);
    //统计
    int total();
    void updatesql(@Param("value") String value);
    void deletesql(@Param("value") String value);
}
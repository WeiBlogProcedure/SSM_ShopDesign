package com.mapper;

import com.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    //添加
    int insert(Admin admin);
    //删除
    void delete(int id);
    //根据id获取数据
    Admin get(int id);
    //修改
    int update(Admin admin);
    //列表
    List<Admin> list(@Param("where") String where);
    //分页
    List<Admin> sealist(@Param("where") String where);
    //统计
    int total();
}
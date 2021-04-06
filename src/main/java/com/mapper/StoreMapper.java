package com.mapper;

import com.entity.Store;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreMapper {
    //添加
    int insert(Store store);
    //删除
    void delete(int id);
    //根据id获取数据
    Store get(int id);
    //修改
    int update(Store store);
    //列表
    List<Store> list(@Param("where") String where);
    //分页
    List<Store> sealist(@Param("where") String where);
    //统计
    int total();
    void updatesql(@Param("value") String value);
    void deletesql(@Param("value") String value);
}
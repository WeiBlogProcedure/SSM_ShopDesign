package com.mapper;

import com.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    //添加
    int insert(Product product);
    //删除
    void delete(int id);
    //根据id获取数据
    Product get(int id);
    //修改
    int update(Product product);
    //列表
    List<Product> list(@Param("where") String where);
    //分页
    List<Product> sealist(@Param("where") String where);
    //统计
    int total();
    void updatesql(@Param("value") String value);
    void deletesql(@Param("value") String value);
}
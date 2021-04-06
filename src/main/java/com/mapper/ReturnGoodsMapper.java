package com.mapper;

import com.entity.ReturnGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReturnGoodsMapper {
    //添加
    int insert(ReturnGoods returnGoods);
    //删除
    void delete(int id);
    //根据id获取数据
    ReturnGoods get(int id);
    //修改
    int update(ReturnGoods returnGoods);
    //列表
    List<ReturnGoods> list(@Param("where") String where);
    //分页
    List<ReturnGoods> sealist(@Param("where") String where);
    //统计
    int total();
    void updatesql(@Param("value") String value);
    void deletesql(@Param("value") String value);
}
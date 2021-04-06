package com.mapper;

import com.entity.OrderGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderGoodsMapper {
    //添加
    int insert(OrderGoods orderGoods);
    //删除
    void delete(int id);
    //根据id获取数据
    OrderGoods get(int id);
    //修改
    int update(OrderGoods orderGoods);
    //列表
    List<OrderGoods> list(@Param("where") String where);
    //分页
    List<OrderGoods> sealist(@Param("where") String where);
    //统计
    int total();
    void updatesql(@Param("value") String value);
    void deletesql(@Param("value") String value);
}
package com.mapper;

import com.entity.Transfer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransferMapper {
    //添加
    int insert(Transfer transfer);
    //删除
    void delete(int id);
    //根据id获取数据
    Transfer get(int id);
    //修改
    int update(Transfer transfer);
    //列表
    List<Transfer> list(@Param("where") String where);
    //分页
    List<Transfer> sealist(@Param("where") String where);
    //统计
    int total();
    void updatesql(@Param("value") String value);
    void deletesql(@Param("value") String value);
}
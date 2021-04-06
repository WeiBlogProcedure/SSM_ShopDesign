package com.mapper;

import com.entity.Sort;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SortMapper {
    //添加
    int insert(Sort sort);
    //删除
    void delete(int id);
    //根据id获取数据
    Sort get(int id);
    //修改
    int update(Sort sort);
    //列表
    List<Sort> list(@Param("where") String where);
    //分页
    List<Sort> sealist(@Param("where") String where);
    //统计
    int total();
    void updatesql(@Param("value") String value);
    void deletesql(@Param("value") String value);
}
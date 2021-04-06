package com.service;

import com.entity.Product;

import java.util.List;

public interface ProductService {
    /**
     * 产品信息列表
     * @param where
     * @return
     */
    List<Product> list(String where);

    /**
     * 分页
     * @param where
     * @return
     */
    List<Product> sealist(String where);

    /**
     * 统计
     * @return
     */
    int total();

    /**
     * 新增产品
     * @param product
     */
    void insert(Product product);

    /**
     * 删除产品
     * @param product
     */
    void delete(Product product);

    /**
     * 更新产品信息
     * @param product
     */
    void update(Product product);

    /**
     * 根据id获取产品信息
     * @param id
     * @return
     */
    Product get(int id);

    /**
     *
     * @param value
     */
    void updatesql(String value);

    /**
     *
     * @param value
     */
    void deletesql(String value);
}

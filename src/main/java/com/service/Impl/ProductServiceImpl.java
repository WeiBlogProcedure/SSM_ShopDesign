package com.service.Impl;

import com.entity.Product;
import com.mapper.ProductMapper;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> list(String where) {
        return productMapper.list(where);
    }

    @Override
    public List<Product> sealist(String where) {
        return productMapper.sealist(where);
    }

    @Override
    public int total() {
        return productMapper.total();
    }

    @Override
    public void insert(Product c) {
        productMapper.insert(c);
    }

    @Override
    public void update(Product c) {
        productMapper.update(c);
    }

    @Override
    public void delete(Product c) {
        productMapper.delete(c.getId());
    }

    @Override
    public Product get(int id) {
        return productMapper.get(id);
    }

    @Override
    public void updatesql(String value) {
        productMapper.updatesql(value);
    }

    @Override
    public void deletesql(String value) {
        productMapper.deletesql(value);
    }
}

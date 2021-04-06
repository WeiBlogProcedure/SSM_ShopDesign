package com.service;

import com.entity.Admin;

import java.util.List;

public interface AdminService {
    /**
     * 获取管理员列表
     * @param where
     * @return
     */
    List<Admin> list(String where);

    /**
     * 分页
     * @param where
     * @return
     */
    List<Admin> sealist(String where);

    /**
     * 统计
     * @return
     */
    int total();

    /**
     * 新增管理员
     * @param admin
     */
    void insert(Admin admin);

    /**
     * 删除管理员
     * @param admin
     */
    void delete(Admin admin);

    /**
     * 修改管理员信息
     * @param admin
     */
    void update(Admin admin);

    /**
     * 根据id获取管理员信息
     * @param id
     * @return
     */
    Admin get(int id);
}

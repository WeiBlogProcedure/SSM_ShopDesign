package com.service;

import com.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 员工信息列表
     * @param where
     * @return
     */
    List<User> list(String where);

    /**
     * 分页
     * @param where
     * @return
     */
    List<User> sealist(String where);

    /**
     * 统计
     * @return
     */
    int total();

    /**
     * 新增员工
     * @param user
     */
    void insert(User user);

    /**
     * 删除员工
     * @param user
     */
    void delete(User user);

    /**
     * 更新员工信息
     * @param user
     */
    void update(User user);

    /**
     * 根据id获取员工信息
     * @param id
     * @return
     */
    User get(int id);

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

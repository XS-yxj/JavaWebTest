package com.dao;

import com.entity.User;

import java.util.List;

/**
 *
 * 与user配置文件相对应的接口
 */
public interface UserDao {

    public User getUser(String username);

    public boolean reviseUser(User user);
}

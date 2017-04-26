package com.dao;

import com.bean.User;

import java.util.List;

/**
 *
 * 与user配置文件相对应的接口
 */
public interface UserDaoInterface {

    public List<User> queryUserList(User user);

    public User getUser(String username);

    public User getUserInfo(String username);

}

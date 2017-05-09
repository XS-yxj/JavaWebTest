package com.service;

import com.entity.User;

/**
 * Created by Apple on 2017/5/8.
 */
public interface UserService {

    public User getUser(String username, String password);

}

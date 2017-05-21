package com.service;

import com.entity.Message;
import com.entity.User;

import java.util.List;

/**
 * Created by Apple on 2017/5/8.
 */
public interface UserService {

    public User getUser(String username, String password);

    public List<Message> queryMessages(String username);

    public int newMessage(String username, String content, String filePath);

}

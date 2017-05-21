package com.service.Impl;

import com.dao.UserDao;
import com.entity.Message;
import com.entity.User;
import com.enums.UserStateEnum;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Apple on 2017/5/8.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUser(String username, String password) {

        User user = userDao.getUser(username);


        if (user == null) {
//            用户名不存在
            return new User().setState(UserStateEnum.ERROR_USERNAME.getState());
        }else if (!user.getPassword().equals(password)){
            System.out.println(user.getPassword()+"---"+password);
//            密码错误
            return new User().setState(UserStateEnum.ERROR_PASSWORD.getState());
        }else {
//            验证成功
            return user;
        }

    }

    @Override
    public List<Message> queryMessages(String username) {
        List<Message> messages = userDao.queryMessages(username);

        return messages;
    }

    @Override
    public int newMessage(String username, String content, String filePath) {
        int count = userDao.newMessage(username, content, filePath);
        return count;
    }
}

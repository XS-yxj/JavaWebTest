package com.service.Impl;

import com.dao.UserDao;
import com.entity.Message;
import com.entity.User;
import com.enums.UserStateEnum;
import com.service.UserService;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Apple on 2017/5/8.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int newUser(String username, String password, String email) {
        int count = userDao.newUser(username, password,email);
        return count;
    }

    @Override
    public User getUser(String username) {
        User user = userDao.getUser(username);
        return user;
    }

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
    public List<String> search(String keyword) {
        List<String> users = userDao.search(keyword);
        return users;
    }

    @Override
    public List<User> queryFriends(String username) {
        List<User> userList = userDao.queryFriends(username);
        return userList;
    }

    @Override
    public List<Message> queryMessages(String username) {
        List<Message> messages = userDao.queryMessages(username);

        return messages;
    }

    @Override
    public List<Message> queryMessageAll(List<User> users) {
        List<Message> messages = userDao.queryMessageAll(users);
        return messages;
    }

    @Override
    public int newMessage(String username, String content, String filePath) {
        int count = userDao.newMessage(username, content, filePath);
        return count;
    }

    @Override
    public int comment(String username, String followerName, Date time, String content) {
        int count = userDao.comment(username, followerName, time, content);
        return count;
    }

    @Override
    public int watchByProcedure(String userA, String userB) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userA", userA);
        map.put("userB", userB);
        map.put("result", null);
        userDao.watchByProcedure(map);
        int count = MapUtils.getInteger(map, "result", 0);
//        System.out.println(count);
        return count;
    }
}

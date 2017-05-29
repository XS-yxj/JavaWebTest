package com.service;

import com.entity.Message;
import com.entity.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Apple on 2017/5/8.
 */
public interface UserService {

     int newUser(String username, String password, String email);

     User getUser(String username);

     User getUser(String username, String password);

    //    查询用户所有关注
     List<User> queryFriends(String username);

     List<Message> queryMessages(String username);

     int newMessage(String username, String content, String filePath);

//    评论
     int comment(String username, String followerName, Date time, String content);

//   关注与取消关注
    int watchByProcedure(String userA, String userB);

}

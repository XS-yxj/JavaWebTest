package com.dao;

import com.entity.Message;
import com.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * 与user配置文件相对应的接口
 */
public interface UserDao {

//    新建用户
     int newUser(@Param("username") String username, @Param("password") String password, @Param("email") String email);

     User getUser(String username);

//    查询用户所有关注
     List<User> queryFriends(String username);

     List<Message> queryMessages(String name);

     int newMessage(@Param("username") String username, @Param("content") String content, @Param("filePath") String filePath);

//    评论
     int comment(@Param("username") String username, @Param("followerName") String followerName, @Param("time") Date time , @Param("content") String content);

//    关注与取消关注
     void watchByProcedure(Map<String, Object> paramMap);


}

package com.dao;

import com.entity.Message;
import com.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * 与user配置文件相对应的接口
 */
public interface UserDao {

    public User getUser(String username);

    public List<Message> queryMessages(String name);

    public int newMessage(@Param("username") String username, @Param("content") String content, @Param("filePath") String filePath);

}

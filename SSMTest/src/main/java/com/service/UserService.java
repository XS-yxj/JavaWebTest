package com.service;

import com.bean.User;
import com.dao.UserDaoInterface;
import com.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 *
 *
 *
 */
public class UserService {


/**
 *     验证用户登录
 */
    public static Boolean checkUser(String username, String password) {

        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        User user = null;

        try {

            sqlSession = dbAccess.getSqlSession();


//            接口式编程，借助mybatis
            UserDaoInterface userDaoInterface = sqlSession.getMapper(UserDaoInterface.class);
            user = userDaoInterface.getUser(username);

            if(user != null){

                if(password.equals(user.getPassword())) {
//                    密码正确
                    return true;

                } else {
//                    密码错误
                    return false;
                }

            }else {
//                用户不存在
                return null;
            }


        } catch (IOException e) {

            e.printStackTrace();
        }

        return false;

    }

/**
 * 获取用户信息
 */
    public static User getUserInfo(String username){

        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        User user = null;


        try {

            sqlSession = dbAccess.getSqlSession();

            UserDaoInterface userDaoInterface = sqlSession.getMapper(UserDaoInterface.class);
            user = userDaoInterface.getUserInfo(username);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return user;
    }








}

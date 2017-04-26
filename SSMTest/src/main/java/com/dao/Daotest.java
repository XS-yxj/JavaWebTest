package com.dao;

import com.db.DBAccess;
import com.bean.User;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apple on 2017/4/24.
 */
public class Daotest {

    public List<User> queryUserList(String email, String username) {

        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        List<User> myUserList = new ArrayList<User>();
//        parameterType只能接受一个参数（封装解决）
        User user = new User();
        user.setEmail(email);
        user.setUsername(username);

        try {

            sqlSession = dbAccess.getSqlSession();

//            接口式编程
            UserDaoInterface userDaoInterface = sqlSession.getMapper(UserDaoInterface.class);
            myUserList = userDaoInterface.queryUserList(user);

//            myUserList = sqlSession.selectList("myUser.queryUserList",user);
//            增删改，事务
//            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            if(sqlSession != null) {
                sqlSession.close();
            }

        }

        return myUserList;
    }


    public static void main(String[] args) {
        Daotest daotest = new Daotest();
        List<User> myUserList = daotest.queryUserList("admin","");

        for(User e: myUserList) {

            System.out.println(e.getEmail() + "\t"+  e.getUsername() + "\t"+ e.getPassword());
        }

    }

}

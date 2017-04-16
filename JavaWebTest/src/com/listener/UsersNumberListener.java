package com.listener;

import com.entity.User;
import com.util.SessionUtil;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;


/**
 * Created by Apple on 2017/3/31.
 * 已知bug：自动调用浏览器会创建2个sessionId。
 */
@WebListener
public class UsersNumberListener implements HttpSessionListener{

    private int usersNumber = 100000;


    public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */

        usersNumber++;
        se.getSession().getServletContext().setAttribute("usersNumber",usersNumber);


        System.out.println("-------Created----------sessionListener------------------");

    }

    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
        usersNumber--;
        se.getSession().getServletContext().setAttribute("usersNumber",usersNumber);

        ArrayList<User> userList = (ArrayList<User>)se.getSession().getServletContext().getAttribute("userList");
        Object user = SessionUtil.getUserBySessionId(userList, se.getSession().getId());
        if(user != null) {
            userList.remove(user);
        }


        System.out.println("-----Destroyed------------sessionListener---------------");
    }
}

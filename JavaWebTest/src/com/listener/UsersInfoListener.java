package com.listener;


import com.entity.User;
import com.util.SessionUtil;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@WebListener
public class UsersInfoListener implements ServletRequestListener{

    private ArrayList<User> userList = new ArrayList<>();

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {


        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        String sessionId = request.getSession().getId();

        if(SessionUtil.getUserBySessionId(userList, sessionId) == null) {
            User user = new User();
            user.setSessionId(sessionId);
            user.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            user.setIp(request.getRemoteUser());
            userList.add(user);

        }

        servletRequestEvent.getServletContext().setAttribute("userList", userList);
    }
}

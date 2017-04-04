package com.util;

import com.entity.User;

import java.util.ArrayList;

/**
 * Created by Apple on 2017/3/31.
 */
public class SessionUtil {

    public static Object getUserBySessionId(ArrayList<User> userList, String sessionId ) {

        for (User u: userList) {
            if (u.getSessionId().equals(sessionId)) {
                return u;
            }
        }

        return null;
    }

}

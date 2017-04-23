package com.util;

import com.entity.User;

import java.util.ArrayList;

/**
 * 在用户数组列表中匹配特定用户，并返回
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

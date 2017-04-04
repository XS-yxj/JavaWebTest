package com.util;


/**
 * Created by Apple on 2017/4/2.
 */
public class SignInUtil {

    static String defaultUsername = "admin";
    static String defaultPassword = "admin";

    static String defaultUsernameZH = "孤世";


    public static Boolean chackUser(String username, String password) {

        if((username.equals(defaultUsername) || username.equals(defaultUsernameZH))
                && password.equals(defaultPassword)) {

            return true;

        } else {
            return false;
        }

    }


}

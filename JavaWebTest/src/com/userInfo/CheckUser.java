package com.userInfo;

/**
 * Created by Apple on 2017/3/27.
 */
public class CheckUser {

    String defaultUsername = "admin";
    String defaultPassword = "admin";

    String defaultUsernameZH = "孤世";


    public Boolean chackUser(User user) {

        if((user.getUsername().equals(defaultUsername) || user.getUsername().equals(defaultUsernameZH))
                && user.getPassword().equals(defaultPassword)) {

            return true;

        } else {
            return false;
        }

    }






}

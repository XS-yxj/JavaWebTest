package com.entity;

import java.util.List;

/**
 * Created by Apple on 2017/5/18.
 */
public class Friend {

    private String username;

    private List<String> friends;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }
}

package com.entity;

import com.enums.UserStateEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class User {

    private String username;
    private String password;
    private String email;
    private String userImagePath;

//    注意此处类型，非枚举
    private int state;

    private String sessionId;
    private String ip;
    private Date time;

    private String[] friends;

    private ArrayList<Message> messages;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUserImagePath() {
        return userImagePath;
    }

    public void setUserImagePath(String userImagePath) {
        this.userImagePath = userImagePath;
    }

    public String[] getFriends() {
        return friends;
    }

    public void setFriends(String[] friends) {
        this.friends = friends;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public int getState() {
        return state;
    }

//    注意返回值处理
    public User setState(int state) {
        this.state = state;
        return this;
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userImagePath='" + userImagePath + '\'' +
                ", state=" + state +
                ", sessionId='" + sessionId + '\'' +
                ", ip='" + ip + '\'' +
                ", time=" + time +
                ", friends=" + Arrays.toString(friends) +
                ", messages=" + messages +
                '}';
    }
}

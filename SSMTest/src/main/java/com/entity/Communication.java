package com.entity;

import java.util.Date;

/**
 * Created by Apple on 2017/5/17.
 */
public class Communication {

    private String messageUsername;
    private String followerName;
    private Date messageTime;
    private Date followTime;

    private String communicationContent;

    public String getFollowerName() {
        return followerName;
    }

    public void setFollowerName(String followerName) {
        this.followerName = followerName;
    }


    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }


    public String getMessageUsername() {
        return messageUsername;
    }

    public void setMessageUsername(String messageUsername) {
        this.messageUsername = messageUsername;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    public String getCommunicationContent() {
        return communicationContent;
    }

    public void setCommunicationContent(String communicationContent) {
        this.communicationContent = communicationContent;
    }

}

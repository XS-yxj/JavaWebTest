package com.enums;

/**
 * Created by Apple on 2017/5/8.
 */
public enum UserStateEnum {

    NATURAL(0,"正常"),
    ERROR_USERNAME(-1,"用户不存在"),
    ERROR_PASSWORD(-2,"密码错误"),
    BAN(-3,"禁止");

    private int state;

    private String stateInfo;

    UserStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

//    ?????
    public static UserStateEnum stateOf(int index) {
        for (UserStateEnum state: values()) {
            if (state.getState() == index) {
                return  state;
            }
        }
        return  null;
    }

}

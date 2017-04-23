package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Apple on 2017/4/22.
 */
@Controller
@RequestMapping("/user")
public class UserMvcController {

    @RequestMapping("/signIn")
    public void userMvcI() {

    }


    @RequestMapping("/signIn_success")
    public String userMvcS() {
        return "user/signIn_success";
    }

    @RequestMapping("/signIn_failure")
    public String userMvcF() {
        return "user/signIn_failure";
    }


}

package com.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Apple on 2017/4/7.
 * 利用反编译，借助Kaptcha自定义加法验证码的验证工具,推荐
 */
public class KaptchaUtil {

    static public Boolean checkCode (HttpServletRequest request) {

        String piccode = (String) request.getSession()
                .getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        String checkcode = request.getParameter("checkCode");


        System.out.println(piccode+"---"+checkcode);


        if (checkcode.equals(piccode)) {
            return true;
        }
        return false;
    }

}

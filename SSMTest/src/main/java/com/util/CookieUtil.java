package com.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Apple on 2017/4/16.
 */
public class CookieUtil {

    static public String getCookieValue(HttpServletRequest request, String str) throws UnsupportedEncodingException {

        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0) {
            for (Cookie c: cookies) {
                if (c.getName().equals("username")) {
//          使用匹配的utf-8解码, 防止Cookie中文乱码
                    str = URLDecoder.decode(c.getValue(), "utf-8");
                    return str;
                }
            }
        }
        return "";
    }


//    --------保存或删除Cookies--------------
    static public void deal(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");


        //        设置Cookie
        String[] isUseCookies = request.getParameterValues("isUseCookie");
        if(isUseCookies != null && isUseCookies.length > 0) {

//        使用编码URLEncode，防止Cookie中文乱码
            String usernameStr = URLEncoder.encode(username, "utf-8");
            String passwordStr = URLEncoder.encode(password, "utf-8");


//        将用户名和密码保存到Cookie中
            Cookie usernameCookie = new Cookie("username", usernameStr);
            Cookie passwordCookie = new Cookie("password", passwordStr);

            //        最大生存期限为七天
            usernameCookie.setMaxAge(60*60*24*7);
            passwordCookie.setMaxAge(60*60*24*7);
//      !!!!!!!需要设置适用路径
            usernameCookie.setPath(request.getContextPath());
            passwordCookie.setPath(request.getContextPath());

            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);


        }else {
//        不记住密码且Cookie中有内容
            Cookie[] cookies = request.getCookies();
            if(cookies != null && cookies.length > 0) {

                for (Cookie c: cookies) {

                    if (c.getName().equals("username") || c.getName().equals("password")) {
                        //      设置Cookie失效并重新保存！！！！
                        c.setMaxAge(0);
//                !!!!!!!需要设置适用路径
                        c.setPath(request.getContextPath());
                        response.addCookie(c);
                    }

                }

            }
        }

    }


}

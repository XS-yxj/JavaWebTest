package com.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Apple on 2017/4/7.
 * 完全自定义的验证码Servlet实现验证，不推荐
 */
public class CheckCodeUtil {

    static public Boolean checkCode(HttpServletRequest request) {

        String piccode = (String) request.getSession().getAttribute("piccode");
        String checkcode = request.getParameter("checkCode");
        checkcode = checkcode.toUpperCase();

        if (checkcode.equals(piccode)) {

            return true;
        }
        return false;
    }

}

package com.servlet;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.util.CheckCodeUtil;
import com.util.SignInUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * servlet 3.0 应用（映射匹配）
 */
@WebServlet(name = "SignInServlet", urlPatterns = "/com/servlet/SignInServlet")
public class SignInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");


////        设置Cookie
//        String[] isUseCookies = request.getParameterValues("isUseCookie");
//        if(isUseCookies != null && isUseCookies.length > 0) {
//
////        使用编码URLEncode，防止Cookie中文乱码
//            String usernameStr = URLEncoder.encode(username, "utf-8");
//            String passwordStr = URLEncoder.encode(password, "utf-8");
//
//
////        将用户名和密码保存到Cookie中
//            Cookie usernameCookie = new Cookie("username", usernameStr);
//            Cookie passwordCookie = new Cookie("password", passwordStr);
//
//            //        最大生存期限为七天
//            usernameCookie.setMaxAge(60*60*24*7);
//            passwordCookie.setMaxAge(60*60*24*7);
//
//            response.addCookie(usernameCookie);
//            response.addCookie(passwordCookie);
//            System.out.println(username);
//
//        }else {
////        不记住密码且Cookie中有内容
//            System.out.println("nono");
//            Cookie[] cookies = request.getCookies();
//            if(cookies != null && cookies.length > 0) {
//
//                for (Cookie c: cookies) {
//
//                    if (c.getName().equals("username") || c.getName().equals("password")) {
//                        //      设置Cookie失效并重新保存！！！！
//                        System.out.println(c.getValue());
//                        c.setMaxAge(0);
//                        response.addCookie(c);
//                    }
//
//                }
//
//            }
//        }



//        验证用户

        Boolean isLegalUser = SignInUtil.checkUser(username, password);
        Boolean isCheckCode = CheckCodeUtil.checkCode(request);


        if (isCheckCode) {

            if(isLegalUser) {

                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect(request.getContextPath() + "/user/signIn_success.jsp");

            }else {

                response.sendRedirect(request.getContextPath() + "/user/signIn_failure.jsp");

            }

        }else {

            PrintWriter out = response.getWriter();
            out.print("验证码错误");

        }






//        if(isLegalUser && isCheckCode) {
//
//            HttpSession session = request.getSession();
//            session.setAttribute("username", username);
//            response.sendRedirect(request.getContextPath() + "/user/signIn_success.jsp");
//
//        }else {
//
//            response.sendRedirect(request.getContextPath() + "/user/signIn_failure.jsp");
//
//        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

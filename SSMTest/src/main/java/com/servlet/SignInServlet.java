package com.servlet;

import com.util.CookieUtil;
import com.util.KaptchaUtil;
import com.util.SignInUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * servlet 3.0 应用（映射匹配）
 */
//@WebServlet(name = "SignInServlet", urlPatterns = "/com/servlet/SignInServlet")
public class SignInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        System.out.println("signIn");

        String username = request.getParameter("username");
        String password = request.getParameter("password");



//        验证用户
        Boolean isLegalUser = SignInUtil.checkUser(username, password);
        Boolean isCheckCode = KaptchaUtil.checkCode(request);

        if (isCheckCode) {

            if(isLegalUser) {

//              删除或保存Cookie
                CookieUtil.deal(request,response);

                HttpSession session = request.getSession();
                session.setAttribute("username", username);
//                session.setAttribute("password", password);
                response.sendRedirect(request.getContextPath()+"/user/signIn_success");

            }else {

                response.sendRedirect(request.getContextPath()+"/user/signIn_failure");

            }

        }else {

            PrintWriter out = response.getWriter();
            out.print("验证码错误");

        }



    }






    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

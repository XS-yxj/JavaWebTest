package com.servlet;

import com.util.CookieUtil;
import com.util.KaptchaUtil;
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
                response.sendRedirect(request.getContextPath() + "/user/signIn_success.jsp");

            }else {

                response.sendRedirect(request.getContextPath() + "/user/signIn_failure.jsp");

            }

        }else {

            PrintWriter out = response.getWriter();
            out.print("验证码错误");

        }



    }






    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

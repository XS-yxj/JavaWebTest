package com.servlet;

import com.service.UserService;
import com.util.CookieUtil;
import com.util.KaptchaUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;



public class SignInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PrintWriter out = response.getWriter();


        String username = request.getParameter("username");
        String password = request.getParameter("password");



//        验证用户
//        Boolean isLegalUser = SignInUtil.checkUser(username, password);
//      数据库验证用户
        Boolean isLegalUser = UserService.checkUser(username,password);
//      检查验证码
        Boolean isCheckCode = KaptchaUtil.checkCode(request);

        if (isCheckCode) {


            if(isLegalUser == null){


                out.print("用户不存在");

            }else if (isLegalUser){


                //              删除或保存Cookie
                CookieUtil.deal(request,response);

                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect(request.getContextPath()+"/seeWorld/" + username );

            }else {

                response.sendRedirect(request.getContextPath()+"/user/signIn_failure");

            }





//            if(isLegalUser) {
//
////              删除或保存Cookie
//                CookieUtil.deal(request,response);
//
//                HttpSession session = request.getSession();
//                session.setAttribute("username", username);
//
//                response.sendRedirect(request.getContextPath()+"/user/signIn_success");
//
//            }else {
//
//                response.sendRedirect(request.getContextPath()+"/user/signIn_failure");
//
//            }
//
//        }else {
//
////            PrintWriter out = response.getWriter();
//            out.print("验证码错误");
////            System.out.println("验证码错误");

        }



    }






    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

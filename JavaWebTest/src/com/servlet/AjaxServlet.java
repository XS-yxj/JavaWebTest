package com.servlet;

import com.util.KaptchaUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Apple on 2017/4/8.
 */
@WebServlet(name = "AjaxServlet", urlPatterns = "/Ajax")
public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.print("Ajax");
//        String keyword = request.getParameter("checkCode");
        Boolean isCheckCode = KaptchaUtil.ajaxCheckCode(request);
        response.getWriter().write(isCheckCode.toString());

    }
}

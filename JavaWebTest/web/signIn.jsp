<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 2017/3/26
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.*" %>


<%--          ---------------使用内置对象-------------------          --%>
<%
//    String username = "";
//    String password = "";
//    String defaultUsername = "admin";
//    String defaultPassword = "admin";
////    防止中文乱码
//    request.setCharacterEncoding("utf-8");
//    username = request.getParameter("username");
//    password = request.getParameter("password");
//
//    if(username.equals(defaultUsername) && password.equals(defaultPassword)) {
////        使用session保持登录状态
//        session.setAttribute("username", username);
////        服务器请求转发
//        request.getRequestDispatcher("signIn_success.jsp").forward(request,response);
//    }else {
////        请求重定向
//        response.sendRedirect("signIn_failure.jsp");
//    }

%>


<%--    -------------------------使用jsp的JavaBean动作标签------------------------        --%>
<%
//    表单提交，防止中文乱码
    request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="userInfo" class="com.entity.User" ></jsp:useBean>
<%--<jsp:useBean id="checkUser" class="com.entity.CheckUser" ></jsp:useBean>--%>
<%--根据表单自动匹配--%>
<jsp:setProperty name="userInfo" property="*" />


<%
//    ----------------没封装业务逻辑--------------
//    String defaultUsername = "孤世";
//    String defaultPassword = "admin";
//
//    if(userInfo.getUsername().equals(defaultUsername)
//            && userInfo.getPassword().equals(defaultPassword)) {
////        使用session保持登录状态
//session.setAttribute("username", userInfo.getUsername());
//
////        服务器请求转发
//        request.getRequestDispatcher("signIn_success.jsp").forward(request,response);
//    } else {
////        请求重定向
//        response.sendRedirect("signIn_failure.jsp");
//    }
%>


<%

    String[] isUseCookies = request.getParameterValues("isUseCookie");
    if(isUseCookies != null && isUseCookies.length > 0) {

//        使用编码URLEncode，防止Cookie中文乱码
        String username = URLEncoder.encode(userInfo.getUsername(), "utf-8");
        String password = URLEncoder.encode(userInfo.getPassword(), "utf-8");


//        将用户名和密码保存到Cookie中
        Cookie usernameCookie = new Cookie("username", username);
        Cookie passwordCookie = new Cookie("password", password);

        //        最大生存期限为七天
        usernameCookie.setMaxAge(60*60*24*7);
        passwordCookie.setMaxAge(60*60*24*7);

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
                    response.addCookie(c);
                }

            }

        }
    }


//    ---------------封装义务逻辑---------------

//    if(checkUser.chackUser(userInfo)) {
////        使用session保持登录状态
//        session.setAttribute("username", userInfo.getUsername());
//
////        请求转发，服务器内部跳转
//        request.getRequestDispatcher("user/signIn_success.jsp").forward(request,response);
//    } else {
////        重定向，客户端二次请求
//        response.sendRedirect("user/signIn_failure.jsp");
//    }



%>
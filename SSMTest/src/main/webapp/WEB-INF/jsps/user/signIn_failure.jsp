<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 2017/3/26
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆失败</title>
</head>
<body>
<h1>登录失败正在返回。。。3秒后跳转</h1>
<%
    response.setHeader("refresh","3;"+request.getContextPath()+"/?signInShow");
%>
</body>
</html>
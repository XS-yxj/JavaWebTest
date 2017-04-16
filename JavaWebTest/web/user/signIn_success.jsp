<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 2017/3/26
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<%--EL表达式--%>
<h3>欢迎您 <font color="green">${username}</font> ，登陆成功。。。3秒后跳转</h3>
<%
    response.setHeader("refresh","3;../newWorld/seeWorld.jsp");
%>
</body>
</html>

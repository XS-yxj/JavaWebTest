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
    <title>Title</title>
</head>
<body>
<h3>欢迎您 <font color="green"><%=session.getAttribute("username") %></font> ，登陆成功。。。</h3>
<%--<jsp:useBean id="userInfo" class="com.userInfo.User" scope="session"/>--%>
<%--<h3>欢迎您 <font color="green"><jsp:getProperty name="userInfo" property="username"/></font> ，登陆成功。。。</h3>--%>
</body>
</html>

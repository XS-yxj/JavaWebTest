<%@ page import="java.util.ArrayList" %>
<%@ page import="com.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 2017/3/31
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线用户数据</title>
    <meta http-equiv="refresh" content="3">
</head>
<body>

<div style="text-align: center">
    <h1>显示当前在线用户人数</h1><hr>
    <h2 id="usersNumber"><%=application.getAttribute("usersNumber") %></h2><hr><br><br>
<%
    String ip;
    ArrayList<User> userList = (ArrayList<User>) request.getServletContext().getAttribute("userList");
    if(userList != null) {
        for (User u: userList) {
            if(u.getIp() == null) {
                ip = "动态路由";
            }else {
                ip = u.getIp();
            }

%>
    IP：ip &nbsp;&nbsp;
    访问时间：<%=u.getTime() %> &nbsp;&nbsp;
    SessionId：<%=u.getSessionId() %> &nbsp;&nbsp;<br>
<%
        }
    }
%>

</div>

</body>
</html>

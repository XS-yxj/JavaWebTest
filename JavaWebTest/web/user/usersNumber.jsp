<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <%--*********EL+JSPL*********--%>
    <h2 id="usersNumber">
        <c:out value="${applicationScope.usersNumber}"></c:out>
    </h2><hr><br><br>
    <c:forEach var="user" items="${applicationScope.userList}">
    <c:if test="${user.ip==null}" var="result">
        IP：<c:out value="动态路由"></c:out>&nbsp;&nbsp;
    </c:if>
    <c:if test="${user.ip!=null}" var="result">
     IP：<c:out value="${user.ip}"></c:out>&nbsp;&nbsp;
    </c:if>
    访问时间：<c:out value="${user.time}"></c:out> &nbsp;&nbsp;
    SessionId：<c:out value="${user.sessionId}"></c:out>&nbsp;&nbsp;<br>
    </c:forEach>


</div>

</body>
</html>

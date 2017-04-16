<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线用户数据</title>
    <meta http-equiv="refresh" content="60*60">
    <link rel="stylesheet" href="base/usersNumber-css.css">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/res/favicon.png" type="image/x-icon"/>
    <script type="text/javascript" src="base/usersNumber-js.js"></script>
</head>

<body>

<div style="text-align: center">
    <div id="nowDate"></div>
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

<br><br><br><br>

<div id="scrollBox1">

    <ul id="con1">
        <li><a href="#"><img src="<%=request.getContextPath()%>/res/background01.jpg" alt="" width="100%" height="100%"></a></li>
        <li><a href="#"><img src="<%=request.getContextPath()%>/res/background02.jpg" alt="" width="100%" height="100%"></a></li>
        <li><a href="#"><img src="<%=request.getContextPath()%>/res/background03.jpg" alt="" width="100%" height="100%"></a></li>
        <li><a href="#"><img src="<%=request.getContextPath()%>/res/background04.jpg" alt="" width="100%" height="100%"></a></li>
        <li><a href="#"><img src="<%=request.getContextPath()%>/res/background05.jpg" alt="" width="100%" height="100%"></a></li>
        <li><a href="#"><img src="<%=request.getContextPath()%>/res/background06.jpg" alt="" width="100%" height="100%"></a></li>
    </ul>
    <ul id="con2"></ul>


</div>


<div id="scrollBox2">

    <ul id="con01">
        <li><a href="#"><img src="<%=request.getContextPath()%>/res/background01.jpg" alt="" width="100%" height="100%"></a></li>
        <li><a href="#"><img src="<%=request.getContextPath()%>/res/background02.jpg" alt="" width="100%" height="100%"></a></li>
        <li><a href="#"><img src="<%=request.getContextPath()%>/res/background03.jpg" alt="" width="100%" height="100%"></a></li>
        <li><a href="#"><img src="<%=request.getContextPath()%>/res/background04.jpg" alt="" width="100%" height="100%"></a></li>
        <li><a href="#"><img src="<%=request.getContextPath()%>/res/background05.jpg" alt="" width="100%" height="100%"></a></li>
        <li><a href="#"><img src="<%=request.getContextPath()%>/res/background06.jpg" alt="" width="100%" height="100%"></a></li>
    </ul>
    <ul id="con02"></ul>


</div>





</body>
<%--未知问题，只有放在此处动画ScrollTop有效--%>
<script type="text/javascript" src="base/usersNumber-js.js"></script>
</html>

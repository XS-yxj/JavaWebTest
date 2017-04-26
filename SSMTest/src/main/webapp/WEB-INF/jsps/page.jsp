<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 2017/4/26
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/seeWorld.css">
    <link rel="shortcut icon" href="<%=request.getContextPath() %>/resources/image/favicon.png" type="image/x-icon"/>
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/seeWorld.js"></script>
</head>
</head>
<body>


<div id="header">
    <div  onclick="moveMenu()">
        <div id="net" >newWord</div>
    </div>
    <div id="point">
        <img src="<%=request.getContextPath() %>/resources/image/favicon.png">
    </div>
</div>



<div id="content">


    <div id="leftMenu">
        <div><img alt="用户图片" width="100%" height="100%"
                  src="<%= request.getContextPath()%>/resources/image/${user.userImagePath}"/></div>
        <div>${user.username}</div>
        <ul>
            <li><a href="#">首页</a></li>
            <li><a href="#">人脉</a></li>
            <li><a href="#">设置</a></li>
            <li><a href="#">帮助</a></li>
            <li><a href="#">待定</a></li>
            <li><a href="<%=request.getContextPath() %>/setting/${user.username}">个人信息</a></li>
        </ul>
    </div>



    <div id="message">
        <%--<div>信息页面</div>--%>
        <t:insertAttribute name="message0" />
    </div>








</div>
</body>
</html>

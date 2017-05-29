<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<title>Title</title>--%>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/page.css">
    <link rel="shortcut icon" href="<%=request.getContextPath() %>/resources/image/favicon.png" type="image/x-icon"/>
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/page.js"></script>
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

<div id="leftMenu">
    <div><img alt="用户图片" width="100%" height="100%"
              src="${pageContext.request.contextPath}/resources/image/${user.userImagePath}"/></div>
    <div>${user.username}</div>
    <ul>
        <li><a href="${pageContext.request.contextPath}/seeWorld">首页</a></li>
        <li><a href="${pageContext.request.contextPath}/${user.username}/friends">人脉</a></li>
        <li><a href="${pageContext.request.contextPath}/${user.username}/setting">设置</a></li>
        <li><a href="${pageContext.request.contextPath}/${user.username}">个人</a></li>
        <li><a href="#">帮助</a></li>
    </ul>
</div>

<div id="content">

    <div id="message">
        <%--<div>信息页面</div>--%>
        <t:insertAttribute name="messages" />
    </div>

</div>
</body>
</html>

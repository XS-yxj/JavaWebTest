<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${username}</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/seeWorld.css">
    <link rel="shortcut icon" href="<%=request.getContextPath() %>/resources/image/favicon.png" type="image/x-icon"/>
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/seeWorld.js"></script>
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
            <li><a href="<%=request.getContextPath() %>/setting">个人信息</a></li>
        </ul>
    </div>



    <div id="message">
        <%--<div>信息页面</div>--%>

        <div id="aMessage">
            <div id="m-time">时间</div>
            <div id="m-user">用户</div>
            <div id="m-content">信息</div>
            <div id="m-discuss">互动</div>
        </div>

    </div>




    <div id="util">
        <div>new</div>
    </div>



</div>






</body>
</html>

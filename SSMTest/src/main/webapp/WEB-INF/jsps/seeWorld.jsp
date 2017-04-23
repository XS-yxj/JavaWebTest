<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 2017/4/15
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${username}</title>
    <link rel="stylesheet" href="resources/seeWorld-css.css">
    <link rel="shortcut icon" href="resources/image/favicon.png" type="image/x-icon"/>
    <script type="text/javascript" src="resources/seeWorld-js.js"></script>
</head>
<body>

<div id="header">
    <div  onclick="moveMenu()">
        <div id="point">
            <img src="resources/image/favicon.png">
        </div>
        <div id="net" >newWord</div>
    </div>

    <div>放眼世界</div>
</div>









<div id="content">


    <div id="leftMenu">
        <div>${username}</div>
        <ul>
            <li><a href="#">首页</a></li>
            <li><a href="#">人脉</a></li>
            <li><a href="#">设置</a></li>
            <li><a href="#">帮助</a></li>
            <li><a href="#">待定</a></li>
            <li><a href="#">个人信息</a></li>
        </ul>
    </div>



    <div id="message">
        <div>信息页面</div>

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

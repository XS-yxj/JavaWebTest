<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 2017/4/26
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 2017/4/25
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息设置</title>
</head>
<body>

<div style="text-align: center">

    <div>${user.username}</div>
    <div><img alt="用户图片" src="<%= request.getContextPath()%>/resources/image/${user.userImagePath}"/></div>
    <div>修改密码</div>
    <div>个人介绍</div>

    <form method="post" action="upload/${username}" enctype="multipart/form-data">
    <input type="file" name="file">
        <input type="submit" />
    </form>



</div>

</body>
</html>

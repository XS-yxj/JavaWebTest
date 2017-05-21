<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${user.username}</title>
    <link rel="stylesheet"  href="<%=request.getContextPath() %>/resources/css/seeWorld.css"/>
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/seeWorld.js"></script>
</head>
<body>

<div class="message">
    <%--<div>信息页面</div>--%>
    <c:forEach  var="message" items="${messages}">
        <div class="aMessage">
            <div class="message-header">
                <div class="m-user">${message.username}</div>
                <div class="m-time">${message.time}</div>
                <div>工具</div>
            </div>
            <div class="m-content">${message.content}</div>
            <div class="m-discuss">互动</div>
        </div>
    </c:forEach>
</div>


<div class="util" onclick="newP()">新建</div>

<div class="newM">
    <form class="newF" action="${pageContext.request.contextPath}/${user.username}/newMessage" method="post" enctype="multipart/form-data">
        <div class="newF-header">
            <div><img class="user-img" alt="用户头像" src="resources/image/233.jpg" width="100%" height="100%" /></div>
            <div class="username">${user.username}</div>
        </div>
        <div><textarea name="message" placeholder="信息（必填）" required></textarea></div>
        <div>
            <input name="file" type="file" />
        </div>
        <div>显示文件图片</div>
        <div><input type="submit"  value="确定"/></div>
    </form>
</div>


</body>
</html>

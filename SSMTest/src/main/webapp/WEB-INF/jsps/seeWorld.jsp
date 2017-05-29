<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${user.username}</title>
    <link rel="stylesheet"  href="<%=request.getContextPath() %>/resources/css/seeWorld.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/message.css" />
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/seeWorld.js"></script>
</head>
<body>

<div class="message">
    <c:forEach  var="message" items="${messages}">
        <div class="aMessage">
            <div class="message-header">
                <div class="m-user"><a href="${pageContext.request.contextPath}/${message.username}">${message.username}</a></div>
                <div class="m-time">
                    <fmt:formatDate value="${message.time}" pattern="yyyy-MM-dd HH:mm:ss"/>
                    <fmt:formatDate value="${message.time}" pattern="yyyyMMddHHmmss" var="t"/>
                </div>
                <div>工具</div>
            </div>
            <div class="m-content">${message.content}</div>
            <c:if test="${!empty message.filePath}">
                <div ><img class="m-img" src="${message.filePath}" width="100%" height="100%" /></div>
            </c:if>
            <div class="communication">
                <c:forEach var="communication" items="${message.communications}" >
                <div class="aCommunication">
                    <div class="followerName"><a href="${pageContext.request.contextPath}/${communication.followerName}">${communication.followerName}</a> : </div>
                    <div class="c-content">${communication.communicationContent}</div>
                    <div class="followTime"><fmt:formatDate value="${communication.followTime}" pattern="yyyy-MM-dd HH:mm:ss" /></div>
                </div>
                </c:forEach>
            </div>
            <div class="m-discuss">
                <form action="${pageContext.request.contextPath}/${user.username}/follow/${message.username}/${t}" method="post">
                    <input type="text" name="content" required/>
                    <input type="submit" />
                </form>
            </div>
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

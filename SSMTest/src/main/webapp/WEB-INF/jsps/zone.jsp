<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${username}</title>
    <link rel="stylesheet"  href="<%=request.getContextPath() %>/resources/css/message.css"/>
    <link rel="stylesheet"  href="<%=request.getContextPath() %>/resources/css/zone.css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/zone.js"></script>
</head>
<body>

<div class="zoneHeader">
    <div class="username">${username}</div>
    <div><img alt="用户图片" width="100%" height="100%"
              src="${pageContext.request.contextPath}/resources/image/${user.userImagePath}"/></div>
    <div class="watch">
    <c:if test="${!(username eq user.username)}" >
        <c:set var="flag" value="0" ></c:set>
        <c:forEach var="friend" items="${userList}">
            <c:if test="${friend.username eq username}" >
                <c:set  var="flag" value="1" ></c:set>
                <a class="a-watch" href="javascript:watchByAjax('${user.username}','${username}')">取消关注</a>
            </c:if>
        </c:forEach>
        <c:if test="${flag eq 0}">
            <a class="a-watch" href="javascript:watchByAjax('${user.username}','${username}')">关注</a>
        </c:if>
    </c:if>
    </div>
</div>



<div>
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
</div>

</body>
</html>

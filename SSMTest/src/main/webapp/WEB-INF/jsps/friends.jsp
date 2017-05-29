<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>人脉</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/friends.css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/zone.js"></script>
</head>
<body>

<div class="zoneHeader">
    <div class="username">${user.username}</div>
    <div><img alt="用户图片" width="100%" height="100%"
              src="${pageContext.request.contextPath}/resources/image/${user.userImagePath}"/></div>
</div>

<div class="friends">
    <div class="aFriend">
        <div class="icon"><img alt="用户图片" width="100%" height="100%"
                               src="${pageContext.request.contextPath}/resources/image/${user.userImagePath}"/></div>
        <div class="name" >${user.username}</div>
        <div class="statue" >取消关注</div>
    </div>

    <c:forEach var="u" items="${userList}">
            <div class="aFriend">
                    <div class="icon">
                        <a href="${pageContext.request.contextPath}/${u.username}">
                        <img alt="用户图片" width="100%" height="100%"
                             src="${pageContext.request.contextPath}/resources/image/${u.userImagePath}"/>
                        </a>
                    </div>
                <div class="name" ><a href="${pageContext.request.contextPath}/${u.username}">${u.username}</a></div>
                <%--<div class="statue" >--%>
                    <%--<a class="a-watch" href="javascript:watchByAjax('${user.username}','${u.username}')">取消关注</a>--%>
                <%--</div>--%>
            </div>
    </c:forEach>

    <%--<c:forEach var="u" items="${userList}">--%>
        <%--<div class="aFriend">--%>
            <%--<div class="icon"><img alt="用户图片" width="100%" height="100%"--%>
                                   <%--src="${pageContext.request.contextPath}/resources/image/${u.userImagePath}"/></div>--%>
            <%--<div class="name" >${u.username}</div>--%>
            <%--<div class="statue" >取消关注</div>--%>
        <%--</div>--%>
    <%--</c:forEach>--%>
    <%--<c:forEach var="u" items="${userList}">--%>
        <%--<div class="aFriend">--%>
            <%--<div class="icon"><img alt="用户图片" width="100%" height="100%"--%>
                                   <%--src="${pageContext.request.contextPath}/resources/image/${u.userImagePath}"/></div>--%>
            <%--<div class="name" >${u.username}</div>--%>
            <%--<div class="statue" >取消关注</div>--%>
        <%--</div>--%>
    <%--</c:forEach>--%>
</div>



</body>
</html>

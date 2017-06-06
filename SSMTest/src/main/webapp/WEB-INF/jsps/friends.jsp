<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>人脉</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/friends.css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/zone.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/friends.js"></script>
</head>
<body>

<div class="zoneHeader">
    <div class="username">${user.username}</div>
    <div><img alt="用户图片" width="100%" height="100%"
              src="${pageContext.request.contextPath}/resources/image/${user.userImagePath}"/></div>
</div>

<%--用户搜索--%>
<div class="f-scratch">
    <form action="${pageContext.request.contextPath}/search/keyword">
        <div><input type="text" id="keyword" name="keyword" placeholder="用户搜索" onkeyup="getMoreContents()" onblur="keywordBlur()" onfocus="getMoreContents()"/></div>
        <div><input type="submit" value="搜索"/></div>
        <div id="popDiv">
            <table id="content_table" bgcolor="#FFFAFA" border="0" cellspacing="0" cellpadding="0">
                <tbody id="content_table_body"></tbody>
            </table>
        </div>
    </form>
</div>




<%--好友列表--%>
<div class="friends">
    <c:forEach var="u" items="${userList}" varStatus="status">
            <div class="aFriend">
                    <div class="icon">
                        <a href="${pageContext.request.contextPath}/${u.username}">
                        <img alt="用户图片" width="100%" height="100%"
                             src="${pageContext.request.contextPath}/resources/image/${u.userImagePath}"/>
                        </a>
                    </div>
                <div class="name" ><a href="${pageContext.request.contextPath}/${u.username}">${u.username}</a></div>
                <div class="statue" >
                    <a class="a-watch" href="javascript:watchByAjax('${user.username}','${u.username}','${status.index}')">取消关注</a>
                </div>
            </div>
    </c:forEach>

</div>



</body>
</html>

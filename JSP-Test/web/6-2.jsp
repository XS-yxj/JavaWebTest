<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 2017/4/8
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言板</title>
</head>
<script>
 function check(aform) {
     for(var i=0; i<aform.length; i++) {
         if(aform.elements[i].value=="") {
             alert(aform.elements[i].title + "不可为空！");
             return false;
         }
     }
 }


</script>
<body>
<%

    if(session.getAttribute("message") != null ) {
        out.println(session.getAttribute("message").toString());
        out.print("<hr>");
    }

%>
<div style="text-align: center">

    <p>留言板</p>
    <form name="myform" action="6-2-action.jsp" method="get" onsubmit="return check(myform)">
        <input type="text" id="name"  title="留言者"  name="name" placeholder="留言者" size="80"><br><br>
        <textarea rows="20" cols="80" id="content"  title="留言内容"  name="content" placeholder="留言内容"></textarea><br>
        <input type="submit" value="提交" style="width:80px;margin: 10px;">
    </form>

</div>



</body>
</html>

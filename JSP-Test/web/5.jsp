<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 2017/4/8
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<html>
<head>
    <title>第五章习题</title>
</head>
<body>

<%
    Date time = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时:mm分:ss秒");
%>
<div style="text-align: center">
    当前时间：<%=sdf.format(time) %>
</div><hr>


<%!
    int fac(int n) {
        int r=1;
        while(n>1) {
            r*=n--;
        }
        return r;
    }
%>
<div style="text-align: center">
    5的阶乘为：<%=fac(5)%>
</div><hr>

<div style="text-align: center">
    <%
        for (int i=0; i<5; i++) {
            for (int j=5; j>i; j--) {
                out.print("&nbsp;");
            }
            int n=i*2+1;
            while (n-->0){
                out.print("*");
                out.print("&nbsp;");
            }

            out.print("<br>");
        }
    %>
</div>



</body>
</html>

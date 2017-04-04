<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 2017/3/26
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.*" %>
<%@ page import="jdk.nashorn.api.scripting.URLReader" %>
<!DOCTYPE html>
<!-- <html lang="en"> -->
<head>
  <meta charset="UTF-8">
  <title>Home实例</title>
  <link rel="stylesheet" href="base/Home-CSS.css">
  <link rel="stylesheet" href="base/Home-CSS3.css">
  <!-- 网页图标 -->
  <link rel="shortcut icon" href="res/favicon.jpg" type="image/x-icon"/>
  <!--chrome具有缓存，外部js文件修改后浏览器不能及时更新-->
  <!--1.可以设置版本号，src="javascript.js?version=10"，？v=Math.random（）-->
  <!--2.Shift+F5，强制刷新-->
  <script type="text/javascript" src="base/javascript.js"></script>
</head>
<body id="background">
<!-- 导航栏 -->
<ul class="topMenu">
  <li>
    <a href="#home"><img src="res/favicon.jpg" alt="logo" width="18px" height="17px">首页</a>
    <div class="hover-transition"></div>
  </li>
  <li>
    <div class="dropdown">
      <a href="#more" class="more">导航</a>
      <div class="dropdown-content">
        <a href="#">链接1</a>
        <a href="#">链接2</a>
        <a href="#">链接3</a>
      </div>
    </div>
  </li>
  <li>
    <a href="#about">关于</a>
    <div class="hover-animation"></div>
  </li>
  <li>
    <button class="sign" style="position: absolute; right:258px; top:10px" onclick="signIn()">登录</button>
  </li>
  <li>
    <button class="sign" style="position: absolute; right:205px; top:10px" onclick="signUp()">注册</button>
  </li>
  <li>
    <form action="">
      <select name="location"class="location">
        <option value="China" selected>中国</option>
        <option value="Other">其他</option>
      </select>
    </form>
  </li>
  <li>
    <input id="clock" disabled/>
  </li>
</ul>



<!-- 网页信息 -->
<div class="show">
  <div class="show-text">
    <h1>世界那么大，我想去看看。</h1>
  </div>
</div>


<!--需要先将form设置为块元素，才可以隐藏-->

<!-- 注册表单 -->
<form action="#signUp" method="post" class="sign" style="display: none;" name="signUpForm">
  <p class="sign">欢迎注册</p>
  <hr  color="#CDD7DC" size="1px">
  <table class="signUp">
    <tr>
      <td><input type="text" placeholder="用户名"></td>
    </tr>
    <tr>
      <td><input type="email" placeholder="邮箱地址"></td>
    </tr>
    <tr>
      <td><input type="password" placeholder="密码"></td>
    </tr>
    <tr>
      <td><input type="password" placeholder="重复密码"></td>
    </tr>
    <tr>
      <td>
        <p class="warn"></p>
      </td>
    </tr>
    <tr>
      <td><input class="submit" type="submit" value="注册"></td>
    </tr>
  </table>
</form>





<%
//    表单提交，防止中文乱码
//  request.setCharacterEncoding("utf-8");

  String username = "";
  String password = "";
  Cookie[] cookies = request.getCookies();
  if(cookies != null && cookies.length > 0) {

    for (Cookie c: cookies) {

      if (c.getName().equals("username")) {

//          使用匹配的utf-8解码, 防止Cookie中文乱码
          username = URLDecoder.decode(c.getValue(), "utf-8");
          System.out.print(username);

      }
      if (c.getName().equals("password")) {

          password = URLDecoder.decode(c.getValue(), "utf-8");

      }
    }

  }

%>




<!-- 登录表单 -->
<form action="<%=request.getContextPath() %>/com/servlet/SignInServlet" method="post" class="sign" name="signInForm">
  <p class="sign">欢迎登录</p>
  <hr  color="#CDD7DC" size="1px">
  <table class="signIn">
    <tr>
      <td colspan="3"><input type="text" name="username" placeholder="用户名" value="<%=username%>" /></td>
    </tr>
    <tr>
      <td><input type="password" name="password" placeholder="密码" value="<%=password%>" /></td>
    </tr>
    <tr>
      <td>
        <a class="getPassword" href="#">忘记密码</a>
        <input id="remember" name="isUseCookie" class="checkbox" type="checkbox"  />
        <label for="remember">记住密码</label>
      </td>
    </tr>
    <tr>
      <td>
        <p class="warn"></p>
      </td>
    </tr>
    <tr>
      <td>
        <input class="submit" type="submit" value="登录">
      </td>
    </tr>
  </table>
</form>




<!-- 改变背景图片 -->
<form action="change">
  <ul class="show-image">
    <li><a class="previous" onclick="changeBackground(1)">《</a></li>
    <li><a class="active" onclick="changeBackground(2)"> # </a></li>
    <li><a class="next" onclick="changeBackground(3)">》</a></li>
  </ul>
</form>


<%@ include file="base/afterbody.jsp"%>
</body>
</html>

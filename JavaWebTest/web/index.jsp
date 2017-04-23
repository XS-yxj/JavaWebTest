<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 2017/3/26
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.net.*" %>
<!DOCTYPE html>
<head>
  <meta charset="UTF-8">
  <title>Home实例</title>
  <link rel="stylesheet" href="base/Home-CSS.css">
  <link rel="stylesheet" href="base/Home-CSS3.css">
  <!-- 网页图标favicon.jpg -->
  <link rel="shortcut icon" href="res/favicon.png" type="image/x-icon"/>
  <!--chrome具有缓存，外部js文件修改后浏览器不能及时更新-->
  <!--1.可以设置版本号，src="javascript.js?version=10"，？v=Math.random（）-->
  <!--2.Shift+F5，强制刷新-->
  <script type="text/javascript" src="base/javascript.js" charset="utf-8"></script>
</head>
<body id="background">





<!-- **************************导航栏************************** -->
<div id="header">
  <ul id="topMenu">
    <li>
      <a href="#home" ><img src="res/favicon.png" alt="logo"/>首页</a><span></span>
    </li>
    <li>
        <a href="#more" class="more">导航</a><span></span>
    </li>
    <li>
      <a href="#about">关于</a><span></span>
    </li>
    <li>
      <button id="signIn" onclick="signIn()">登录</button>
    </li>
    <li>
      <button id="signUp" onclick="signUp()">注册</button>
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
</div>


<%

    String username = "";
    String password = "";
    Cookie[] cookies = request.getCookies();
    if(cookies != null && cookies.length > 0) {

        for (Cookie c: cookies) {

            if (c.getName().equals("username")) {

//          使用匹配的utf-8解码, 防止Cookie中文乱码
                username = URLDecoder.decode(c.getValue(), "utf-8");

            }
            if (c.getName().equals("password")) {

                password = URLDecoder.decode(c.getValue(), "utf-8");
            }
        }

    }

%>





<%--************************内容栏*****************************--%>
<div id="content" >

  <!-- 网页信息 -->
  <div id="show">
      <p>世界那么大，我想去看看。</p>
  </div>

    <!-- 注册表单 -->
    <div id="signUp-div">
        <form action="#signUp" method="post" class="sign" name="signUpForm">
            <h4 class="sign">欢迎注册</h4>
            <div><input type="text" placeholder="用户名"></div>
            <div><input type="email" placeholder="邮箱地址"></div>
            <div><input type="password" placeholder="密码"></div>
            <div><input type="password" placeholder="重复密码"></div>
            <div><input class="submit" type="submit" value="注册"></div>
        </form>
    </div>

    <%--登录表单--%>
    <div  id="signIn-div">
      <form action="<%=request.getContextPath() %>/com/servlet/SignInServlet" method="post" class="sign" name="signInForm">
        <h4 class="sign">欢迎登录</h4>
        <div>
            <input type="text" name="username" placeholder="用户名" value="<%=username%>" />
        </div>
        <div>
            <input type="password" name="password" placeholder="密码" value="<%=password%>" />
        </div>
        <div class="sfg-1">
            <div>
                <a  id="getPassword" href="#">忘记密码</a>
            </div>
            <div>
                <input  id="remInput" name="isUseCookie" type="checkbox" checked/>
            </div>
            <div>
               <label id="remLaber" for="remInput" >记住密码</label>
            </div>
        </div>
        <div class="sfg-2">
            <div>
                  <a href="javascript:reloadCode();"><img id="imageCheckCode" alt="验证码" title="验证码"  src="randomcode.jpg" /></a>
            </div>
            <div>
               <img id="isTrue"  src="res/isFalse.png"  >
            </div>
            <div>
                <input type="text"  name="checkCode"  id="checkCode" onkeyup="tryAjax()"/>
            </div>
        </div>
        <div><input type="submit" value="登录"></div>
      </form>
    </div>

</div>


<!-- 改变背景图片 -->
<div id="changeGBI">
    <ul>
        <li><a  id="previous" onclick="changeBackground(1)">《</a></li>
        <li><a  id="active" onclick="changeBackground(2)"> # </a></li>
        <li><a  id="next" onclick="changeBackground(3)">》</a></li>
    </ul>
</div>



</body>
</html>

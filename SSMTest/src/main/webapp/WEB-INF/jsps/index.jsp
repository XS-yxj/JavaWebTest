<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
  <meta charset="UTF-8">
  <title>Home实例</title>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/index.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/index3.css">
  <!-- 网页图标favicon.jpg -->
  <link rel="shortcut icon" href="<%=request.getContextPath() %>/resources/image/favicon.png" type="image/x-icon"/>
  <!--chrome具有缓存，外部js文件修改后浏览器不能及时更新-->
  <!--1.可以设置版本号，src="index.js?version=10"，？v=Math.random（）-->
  <!--2.Shift+F5，强制刷新-->
  <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/index.js" charset="utf-8"></script>
</head>
<body id="background">





<!-- **************************导航栏************************** -->
<div id="header">
  <ul id="topMenu">
    <li>
      <a href="#home" ><img src="resources/image/favicon.png" alt="logo"/>首页</a><span></span>
    </li>
    <li>
        <a href="#more" class="more">导航</a><span></span>
    </li>
    <li>
      <a href="#about">关于</a><span></span>
    </li>
    <li>
      <button id="signIn" onclick="signInShow()">登录</button>
    </li>
    <li>
      <button id="signUp" onclick="signUpShow()">注册</button>
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

<%--************************内容栏*****************************--%>
<div id="content" >

  <!-- 网页信息 -->
  <div id="show">
      <p>世界那么大，我想去看看。</p>
  </div>

    <!-- 注册表单 -->
    <div id="signUp-div">
        <form action="signUp" method="post" class="sign" name="signUpForm">
            <h4 class="sign">欢迎注册</h4>
            <div><input type="text" id="usernameTry" name="username" placeholder="用户名" onkeyup="checkUsername()" required></div>
            <div><input type="email" name="email" placeholder="邮箱地址" required></div>
            <div><input type="password" name="password" id="password" placeholder="密码" required></div>
            <div><input type="password" name="rePassword" id="rePassword" placeholder="重复密码" onkeyup="checkRePassword()" required></div>
            <div class="sfg-2">
                <div>
                    <a href="javascript:reloadCode0();"><img id="imageCheckCode0" alt="验证码" title="验证码"  src="randomcode.jpg" /></a>
                </div>
                <div>
                    <img id="isTrue0"  src="resources/image/isFalse.png"  >
                </div>
                <div>
                    <input type="text"  name="checkCode"  id="checkCode0" onkeyup="tryAjax0()"/>
                </div>
            </div>
            <div id="warn-signUp"></div>
            <div><input class="submit" type="submit" id="signUpButton" value="注册"></div>
        </form>
    </div>

    <%--登录表单--%>
    <div  id="signIn-div">
      <form action="signIn" method="post" class="sign" name="signInForm">
        <h4 class="sign">欢迎登录</h4>
        <div>
            <input type="text" name="username" id="username" placeholder="用户名"   required/>
        </div>
        <div>
            <input type="password" name="password" placeholder="密码" value="${cookie.password.value}" required/>
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
               <img id="isTrue"  src="resources/image/isFalse.png"  >
            </div>
            <div>
                <input type="text"  name="checkCode"  id="checkCode" onkeyup="tryAjax()" required/>
            </div>
        </div>
        <div id="warn-signIn"></div>
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
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        //$.cookie("username") 获取name为city的Cookie的值
        //$("#username").val(str) 设置id="username"的元素的值为str
        $("#username").val($.cookie("username"));
    });
</script>
</html>

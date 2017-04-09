
// 改变背景图片
function  changeBackground(num){
	// alert("8979");
	switch(num){

		case 1: document.getElementById("background").style.background="url(res/background01.jpg)"; break;
		case 2: document.getElementById("background").style.background="url(res/background02.jpg)"; break;
		case 3: document.getElementById("background").style.background="url(res/background03.jpg)"; break;
	}

	 // var image{"url(res/background01.jpg)","url(res/background02.jpg)","url(res/background03.jpg)"}

	 // if(1<=num<3)
	 // {
	 // 	document.getElementById("background").style.background=image[i];
	 // }


	// document.getElementById("background").style.background="url(res/background01.jpg)";
}


function signIn() {
    document.getElementsByName("signInForm")[0].style.display = "inline-block";
    document.getElementsByName("signUpForm")[0].style.display = "none";
}

function signUp() {
    document.getElementsByName("signUpForm")[0].style.display = "inline-block";
    document.getElementsByName("signInForm")[0].style.display = "none";
}

// function reloadCode() {
//     //自定义，添加时间确保刷新
//     var time = new Date().getTime();
//     document.getElementById("imageCheckCode").src="randomcode.jpg?d="+time;
//     // document.getElementById("imageCheckCode").src="com/servlet/CheckCodeServlet?d="+time;
//     //------------"<%"会有转换？？？？？------------------------
//     // document.getElementById("imageCheckCode").src="<%=request.getContextPath() %>/com/servlet/CheckCodeServlet?d="+time;
// }

function reloadCode() {
    document.getElementById("imageCheckCode").src="randomcode.jpg";
}

var xmlHttp;
function tryAjax() {

	var content = document.getElementById("checkCode");
	if(content == "") {
		return;
	}
	xmlHttp = createXMLHttp();
//		向服务器发送数据，escape()解决中文乱码
	var url = "Ajax?ajaxCheckCode=" + escape(content.value);
//	true表示异步，js会在森达方法之后继续执行，而不等待服务器响应
	xmlHttp.open("GET", url, true);
//	绑定回调方法，监视xmlHttp的状态改变（4，完成）
//	-------注意此处为callback而非callback()----------------------
	xmlHttp.onreadystatechange = callback;
	xmlHttp.send();

}

function createXMLHttp() {
	var xmlHttp;
	if(window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	}else {
		//兼容IE6以下
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlHttp;
}

function callback() {
    var e = document.getElementById("isTrue");
	if(xmlHttp.readyState==4 && xmlHttp.status==200) {
		//交互成功，响应数据为文本格式
		var result = xmlHttp.responseText;
		if(result==="true") {
            e.style="display:img; width: 20px; height: 20px;";
            e.alt="T";
            e.src="res/isTrue.png"
        }else {
            e.style="display:img; width: 20px; height: 20px;";
            e.alt="F";
            e.src="res/isFalse.png"
        }
	}
}







// 时钟
var strClock;
function clock(){
	var time = new Date();

	strClock = time.getHours() +":"+ time.getMinutes() +":"+ time.getSeconds();
	document.getElementById("clock").value = strClock;
}
setInterval(clock,1000);



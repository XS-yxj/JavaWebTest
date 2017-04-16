
// 改变背景图片
function  changeBackground(num){
	switch(num){

		case 1: document.getElementById("background").style.background="url(res/background01.jpg)";break;
		case 2: document.getElementById("background").style.background="url(res/background02.jpg)";break;
		case 3: document.getElementById("background").style.background="url(res/background03.jpg)";break;
	}

}


function signIn() {
    document.getElementById("signIn-div").style.display = "inline-block";
    document.getElementById("signUp-div").style.display = "none";
}

function signUp() {
    document.getElementById("signUp-div").style.display = "inline-block";
    document.getElementById("signIn-div").style.display = "none";

}




//处理验证码“看不清”
function reloadCode() {
    //请求新验证码
    document.getElementById("imageCheckCode").src = "randomcode.jpg";
    //输入框置空
    document.getElementById("checkCode").value = "";
    //隐藏实时验证码图片
    document.getElementById("isTrue").style.opacity = "0";
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
//获取XMLHttp对象，解决兼容性
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
//接受服务器响应和改变前端内容
function callback() {
    var e = document.getElementById("isTrue");
	if(xmlHttp.readyState==4 && xmlHttp.status==200) {
		//交互成功，响应数据为文本格式
		var result = xmlHttp.responseText;
		if(result==="true") {
            e.style="opacity: 1;";
            e.alt="T";
            e.src="res/isTrue.png"
        }else {
            e.style="opacity: 1;";
            e.alt="F";
            e.src="res/isFalse.png"
        }
	}
}









window.onload = function (){
    // 时钟
	showtime();
}


function showtime(){
    var myDate = new Date();
    var h = myDate.getHours();
    var m = checkTime(myDate.getMinutes());
    var s = checkTime(myDate.getSeconds());

    var strClock = h + ':' + m + ':' + s;

    document.getElementById("clock").value = strClock;

    //每隔500毫秒执行showtime一次
    setTimeout(showtime,500);
}

//格式控制
function checkTime(i){
    return i>9 ? i : '0'+i;
}



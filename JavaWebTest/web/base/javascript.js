
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
    // alert("11");
    document.getElementsByName("signInForm")[0].style.display = "inline-block";
    document.getElementsByName("signUpForm")[0].style.display = "none";
}

function signUp() {
    // alert("11");
    document.getElementsByName("signUpForm")[0].style.display = "inline-block";
    document.getElementsByName("signInForm")[0].style.display = "none";
}

function reloadCode() {
    //自定义，添加时间确保刷新
    var time = new Date().getTime();
    document.getElementById("imageCheckCode").src="randomcode.jpg?d="+time;
    // document.getElementById("imageCheckCode").src="com/servlet/CheckCodeServlet?d="+time;
    //------------"<%"会有转换？？？？？------------------------
    // document.getElementById("imageCheckCode").src="<%=request.getContextPath() %>/com/servlet/CheckCodeServlet?d="+time;
}

function reloadCode() {
    document.getElementById("imageCheckCode").src="randomcode.jpg";
}





// 时钟
var strClock;
function clock(){
	var time = new Date();

	strClock = time.getHours() +":"+ time.getMinutes() +":"+ time.getSeconds();
	document.getElementById("clock").value = strClock;
}
setInterval(clock,1000);



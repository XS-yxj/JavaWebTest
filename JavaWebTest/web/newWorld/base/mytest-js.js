/**
 * Created by Apple on 2017/4/14.
 */

// var onDiv = document.getElementById("menu-left");
// var topDiv = document.getElementById("menu-top");

//页面载入时就启动
window.onload = function () {
    var onDiv = document.getElementById("menu-left");
    // alert(onDiv.value);
    onDiv.onmouseover = function() {
        startMove(0);
        startChange(1);
    }
    onDiv.onmouseout = function() {
        startMove(-200);
        startChange(0.3);
    }

}



//------------移动动画----------------------
//定时器变量
var timerM = null;
function startMove(iTarget){
    //避免多个定时器触发,移动翻倍
    clearInterval(timerM);
    var onDiv = document.getElementById("menu-left");
    var content = document.getElementById("content");

    timerM = setInterval(function () {

        var speed = (iTarget-onDiv.offsetLeft)/5;

        //解决浏览器忽略像素小数问题（无法正常复位）,向前向后取整
        speed = speed >0 ? Math.ceil(speed):Math.floor(speed);

        if(onDiv.offsetLeft == iTarget){
            clearInterval(timerM);
        }else {
            onDiv.style.left = onDiv.offsetLeft + speed + 'px';
            content.style.width = content.offsetWidth - speed +'px';
        }
    },30)
}


//---------------透明度渐变动画----------------------
var timerC= null;
var alpha = 0.6;
function startChange(iOpacity){
    //避免多个定时器触发
    clearInterval(timerC);
    var onDiv = document.getElementById("menu-left");
    var content = document.getElementById("content");

    timerC = setInterval(function () {

        var speed = (iOpacity-alpha)/50;

        if(onDiv.offsetLeft == iOpacity){
            clearInterval(timerC);
        }else {
            alpha += speed;
            onDiv.style.opacity = alpha;
        }
    },30)
}
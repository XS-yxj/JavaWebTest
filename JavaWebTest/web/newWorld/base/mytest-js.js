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

//定时器变量
var timerM = null;
function startMove(iTarget){
    //避免多个定时器触发,移动翻倍
    clearInterval(timerM);
    var onDiv = document.getElementById("menu-left");
    var content = document.getElementById("content");

    timerM = setInterval(function () {

        var speed = 0;
        if(onDiv.offsetLeft > iTarget){
            speed = -10;
        }else {
            speed = 10;
        }

        if(onDiv.offsetLeft == iTarget){
            clearInterval(timerM);
        }else {
            onDiv.style.left = onDiv.offsetLeft + speed + 'px';
            content.style.width = content.offsetWidth - speed +'px';
        }
    },30)
}



var timerC= null;
var alpha = 0.6;
function startChange(iOpacity){
    //避免多个定时器触发
    clearInterval(timerC);
    var onDiv = document.getElementById("menu-left");
    var content = document.getElementById("content");

    timerC = setInterval(function () {

        var speed = 0;
        if(alpha > iOpacity){
            speed = -0.001;
        }else {
            speed = 0.001;
        }

        if(onDiv.offsetLeft == iOpacity){
            clearInterval(timerC);
        }else {
            alpha += speed;
            onDiv.style.opacity = alpha;
        }
    },30)
}
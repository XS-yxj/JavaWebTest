/**
 * Created by Apple on 2017/4/14.
 */



window.onload = function (){
    // 时钟
    showtime();




    move1();
    move2();



}

//-----------------------    完整时间    ----------------------------------
function showtime(){
    var myDate = new Date();

    var year = myDate.getFullYear();
    var month = myDate.getMonth() + 1;
    var day = myDate.getDay();

//      星期几
    var weekDay = ' 星期'+'日一二三四五六'.charAt(day) +' ';

    var h = myDate.getHours();
    var m = checkTime(myDate.getMinutes());
    var s = checkTime(myDate.getSeconds());

    var strClock = year+'年'+month+'月'+day+'日'+weekDay+h+':'+m+':'+s;

    document.getElementById("nowDate").innerHTML = strClock;
    //每隔500毫秒执行showtime一次
    setTimeout(showtime,500);
}

//格式控制
function checkTime(i){
    return i>9 ? i : '0'+i;
}
//--------------------------------------------------------------------------


//----------------------   无缝滚动动画   ------------------


//使用window对象的setInterval方法，作为第一个参数传递的function必须在全局作用域中定义，否则会出现报错而无法执行。
var area1 = document.getElementById("scrollBox1");
var con1 = document.getElementById("con1");
var con2 = document.getElementById("con2");
function move1() {



//    克隆
    con2.innerHTML = con1.innerHTML;


// 初始值
    area1.scrollTop = 0;
    // alert();
    var time = 10;
    var myScroll = setInterval('scrollReset()', time);



//  悬停效果
    area1.onmouseover = function () {
        clearInterval(myScroll);
    }
    area1.onmouseout = function () {
        myScroll = setInterval('scrollReset()', time);
    }
}

function scrollReset() {
    //    con1滚动完复位
    if(area1.scrollTop >= con1.offsetHeight) {
        area1.scrollTop = 0;
    }else {
        area1.scrollTop++
    }
}




//----------------------   间歇性滚动动画   ------------------


//使用window对象的setInterval方法，作为第一个参数传递的function必须在全局作用域中定义，否则会出现报错而无法执行。
var area2 = document.getElementById("scrollBox2");
var con01 = document.getElementById("con01");
var con02 = document.getElementById("con02");
var iLiHeight = 250;
var delay = 2000;
var time = 1;
var myScroll2;
function move2() {


    //初始化,且进入循环
    setTimeout("startMove()",delay);



//    克隆
    con02.innerHTML += con01.innerHTML;


//  初始值
    area2.scrollTop = 0;
    // alert();

   // myScroll2 = setInterval('scrollReset1()', time);



//  悬停效果
    area2.onmouseover = function () {
        clearInterval(myScroll2);
    }
    area2.onmouseout = function () {
        myScroll2 = setInterval('scrollReset1()', time);
    }
}


//进入以下任意一个方法即可循环


function scrollReset1() {

    area2.scrollTop++;

    if(area2.scrollTop%iLiHeight == 0){
        clearInterval(myScroll2);
    //         延时
        setTimeout("startMove()",delay);
    }
    else {
        //用以下会导致间隙动画一轮，之后无缝动画（问题未知，但处在本就不合理导致此方法快一倍）
        // area2.scrollTop++;
        if(area2.scrollTop >= area2.scrollHeight/2){
            area2.scrollTop = 0;
        }
    }

}

function startMove() {
    area2.scrollTop++;
    myScroll2 = setInterval("scrollReset1()",time);
}

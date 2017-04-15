/**
 * Created by Apple on 2017/4/15.
 */


window.onload=function () {

        var  message = document.getElementById("message");
        var menu = document.getElementById("leftMenu");
        var header = document.getElementById("header");
        message.style.width= message.offsetWidth - 200 +'px';
        message.style.left = '200px';
        message.style.top= '45px';
        menu.style.left = '0px';
        header.style.top= '0px';

}


function moveMenu() {
    var menu = document.getElementById("leftMenu");
    var  message = document.getElementById("message");
    //解决连击问题
    if(menu.offsetLeft==0 || menu.offsetLeft== -200){
        if(menu.offsetLeft >= 0){
            menu.style.left = '-200px';

            message.style.left = '0px';
            message.style.width = message.offsetWidth + 200 +'px';
        }else {
            menu.style.left = '0px';

            message.style.left = '200px';
            message.style.width = message.offsetWidth - 200 +'px';
        }
    }






}
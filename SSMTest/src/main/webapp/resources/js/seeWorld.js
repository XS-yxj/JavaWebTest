function newP() {
    var div = document.getElementsByClassName("newM")[0];
    var divN = document.getElementsByClassName("util")[0];
    if(div.style.display == "none") {
        divN.innerHTML="取消";
        div.style.display="block";
    }else {
        divN.innerHTML="新建";
        div.style.display="none";
    }
}
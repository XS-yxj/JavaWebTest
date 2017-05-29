//ajax处理关注和取消
// function watch() {
//
// }

var xmlHttpForWatch;
function watchByAjax( userA, userB ) {

    xmlHttp0 = createXMLHttpForWatch();
    var url = encodeURI(userA) + "/watch/" + encodeURI(userB);
//	true表示异步，js会在森达方法之后继续执行，而不等待服务器响应
    xmlHttp0.open("GET", url, true);
//	绑定回调方法，监视xmlHttp的状态改变（4，完成）
//	-------注意此处为callback而非callback()----------------------
    xmlHttp0.onreadystatechange = callbackForWatch;
    xmlHttp0.send();

}
//获取XMLHttp对象，解决兼容性
function createXMLHttpForWatch() {
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
function callbackForWatch() {
    var e = document.getElementsByClassName("a-watch")[0];
    if(xmlHttp0.readyState==4 && xmlHttp0.status==200) {
        //交互成功，响应数据为文本格式
        var result = xmlHttp0.responseText;
        if(result=="1") {
            e.innerHTML = "取消关注";
        }else {
            e.innerHTML = "关注";
        }
    }
}
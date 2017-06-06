//ajax处理关注和取消

//js获取项目根路径，如： http://localhost:8083/uimcardprj
function getRootPath(){
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
}

var xmlHttpForWatch;
var nodeN;
function watchByAjax( userA, userB , node) {
    nodeN = node;
    xmlHttpForWatch = createXMLHttpForWatch();
    var url = getRootPath() + "/" + encodeURI(userA) + "/watch/" + encodeURI(userB);
//	true表示异步，js会在森达方法之后继续执行，而不等待服务器响应
    xmlHttpForWatch.open("GET", url, true);
//	绑定回调方法，监视xmlHttp的状态改变（4，完成）
//	-------注意此处为callback而非callback()----------------------
    xmlHttpForWatch.onreadystatechange = callbackForWatch;
    xmlHttpForWatch.send();

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
    var e = document.getElementsByClassName("a-watch")[nodeN];
    if(xmlHttpForWatch.readyState==4 && xmlHttpForWatch.status==200) {
        //交互成功，响应数据为文本格式
        var result = xmlHttpForWatch.responseText;
        if(result=="1") {
            e.innerHTML = "取消关注";
        }else {
            e.innerHTML = "关注";
        }
    }
}
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

var xmlHttpForSearch;
function getMoreContents() {

    var content = document.getElementById("keyword");
    if(content.value==""){
        clearContent();
        return;
    }
    xmlHttpForSearch=createXMLHttpForSearch();
    var url= getRootPath()+  "/search?keyword="+ encodeURI(content.value);
    xmlHttpForSearch.open("GET", url, true);
    xmlHttpForSearch.onreadystatechange = callbackForSearch;
    xmlHttpForSearch.send(null);
}

function createXMLHttpForSearch() {
    var xmlHttp;
    if(window.XMLHttpRequest){
        xmlHttp=new XMLHttpRequest();
    }
    if(window.ActiveXObject){
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
        if(!xmlHttp){
            xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
        }
    }
    return xmlHttp;
}

function callbackForSearch() {
    if(xmlHttpForSearch.readyState==4 && xmlHttpForSearch.status==200){
        var result=xmlHttpForSearch.responseText;
        var json=eval("("+result+")");
        // alert(json);
        setContent(json);
    }
}

function setContent(contents) {
    clearContent();
    setLocation();
    var size = contents.length;
    for(var i=0; i<size; i++){
        var nextNode=contents[i];
        var tr=document.createElement("tr");
        var td=document.createElement("td");
        td.setAttribute("border", "0");
        td.setAttribute("bgcolor", "#FFFFFA");
        td.onmouseover=function () {
            this.className='mouseOver';
        };
        td.onmouseout=function () {
            this.className='mouseOut';
        };
        td.onclick=function () {
        //    点击关联数据时，数据进入输入框
            document.getElementById("keyword").value=this.innerHTML;
        };
        var text=document.createTextNode(nextNode);
        td.appendChild(text);
        tr.appendChild(td);
        document.getElementById("content_table_body").appendChild(tr);
    }
}

//清空之前的数据
function clearContent() {
    var contentTableBody=document.getElementById("content_table_body");
    var size=contentTableBody.childNodes.length;
    for(var i=size-1; i>=0; i--){
        contentTableBody.removeChild(contentTableBody.childNodes[i]);
    }
    document.getElementById("popDiv").style.border="none";
}

//失去焦点清空
function keywordBlur() {
    setTimeout(clearContent, 100);
    // clearContent();
}

function setLocation() {
    var content=document.getElementById("keyword");
    var width=content.offsetWidth;
    var left=content["offsetLeft"];
    var top=content["offsetTop"]+content.offsetHeight;
    var popDiv=document.getElementById("popDiv");
    popDiv.style.border="black 1px solid";
    popDiv.style.left=left+"px";
    popDiv.style.top=top+"px";
    popDiv.style.width=width+"px";
    document.getElementById("content_table").style.width=width+ "px";
}
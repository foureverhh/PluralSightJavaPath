<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-03-23
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<html>
<head>
    <title>Ajax demo</title>
</head>
<body>
//同66行的ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");呼应使用
<form action="#" enctype="application/x-www-form-urlencoded"></form>
<h1>Ajax ajax request</h1>
<hr>
    <label for="uname">user name:</label>
    <input type="text" name="uname" id="uname" value=""/>
    <br>
    <label for="pwd">  password:</label>
    <input type="password" name="pwd" id="pwd" value=""/>
    <br>
    <input type="button" value="ajaxReq" onclick="ajaxReq()"/>
<div id="showDiv"></div>
<script type="text/javascript">

    let div = document.getElementById("showDiv");
    let hello = document.createTextNode("hello World");
    div.appendChild(hello);
    div.style.setProperty("overflow","auto");
    div.style.setProperty("border","solid 1px green");
    div.style.width = "200px";
    div.style.height = "100px";
    function ajaxReq() {


        let name = document.getElementById("uname").value;
        let pwd = document.getElementById("pwd").value;

        let ajax;
        if(window.XMLHttpRequest){ //firefox
            ajax = new XMLHttpRequest();
        }else if(window.ActiveXObject){
            ajax = new ActiveXObject("Msxm12.XMLHTTP")
        }

        ajax.onreadystatechange = function () {
            if(ajax.readyState === 4){
                if(ajax.status === 200){
                    let result = ajax.responseText;
                    let showDiv = document.getElementById("showDiv");
                    showDiv.innerHTML = result;
                }
            }
        }
        /*
        //get方式
        ajax.open("get","ajax?name="+name+"&pwd="+ pwd);
        ajax.send(null);
        */
        //post方式
        ajax.open("post","ajax");
        //同第15行对应，使发送的内容"name=张珊&pwd=123"，被识别为键值对
        ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        ajax.send("name=张珊&pwd=123");

        alert("ajax request sent")
        //获取元素
        div.appendChild(document.createElement("br"));
        div.appendChild(document.createTextNode("I am from on click ajaxReq()"));
    }
</script>
</body>
</html>

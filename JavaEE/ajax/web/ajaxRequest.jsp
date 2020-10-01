<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-06-03
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax Request</title>
    <script type="text/javascript">
        function ajaxReq() {
            let name = document.getElementById("name").value;
            let pwd = document.getElementById("pwd").value;
            let ajax = new XMLHttpRequest();
            ajax.onreadystatechange = ()=>{
               if(ajax.readyState === 4 && ajax.status === 200){
                   let result  = ajax.responseText;
                   alert(result);
                   document.getElementById("showInfo").innerHTML = result;
               }
            };

            //发送请求
                /*
                //get请求
                ajax.open("get","ajax?name=" + name + "&pwd=" + pwd);
                ajax.send(null);
                */
                //post请求
                ajax.open("post","ajax");
                //将表单内容以键值对形式上传服务器
                ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
                ajax.send("name=" + name + "&pwd=" + pwd);
        }
    </script>
    <style type="text/css">
        #showInfo {
            border: solid 1px;
            width: 200px;
            height: 100px;
        }
    </style>
</head>
<body>
    <h3>Ajax Request</h3>
    <hr>
    <form action="#">
        name: <input id="name" type="text" name="name" placeholder="name"><br>
        pwd:  <input id="pwd" type="text" name="pwd" placeholder="pwd"> <br>
    </form>
    <div id="showInfo"></div>
    <hr>
    <input type="button" onclick="ajaxReq()" value="ajax" >
</body>
</html>

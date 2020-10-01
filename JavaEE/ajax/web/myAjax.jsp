<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-06-02
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>My Ajax</title>
    <script type="text/javascript">
        function getData(){
            //initial ajax XMLHttpRequest
            let ajax;
            if(window.XMLHttpRequest){ //firefox
                ajax = new XMLHttpRequest();
            }else if(window.ActiveXObject){ //IE
                ajax = new ActiveXObject("Msxml2.XMLHTTP")
            }

            let info = document.getElementById("showInfo");
            //override onreadystatchange method
            ajax.onreadystatechange = function () {
                if(ajax.readyState === 4 && ajax.status === 200){
                    //获取响应内容
                    let result = ajax.responseText;
                    //处理响应内容


                    alert(result)
                    //info.innerHTML = "哈哈，今天的雾霾真的是新鲜！"
                    info.innerHTML = result;
                    let imageZone = document.createElement("div");
                    let image = document.createElement("img");
                    image.src = "img/sample.png";
                    image.style.width = "20%";
                    image.style.height = "20%";
                    imageZone.append(image);
                    info.appendChild(imageZone);
                }else if(ajax.status === 404){
                    info.innerHTML = "请求资源不存在";
                }else if(ajax.status === 500){
                    info.innerHTML = "服务器繁忙";
                }
            }
            //发送请求
            //ajax.open("get","ajax",async,username,password);
            ajax.open("GET","ajax");//默认是异步
            ajax.send(null);

            //Test async or sync
            alert("I am async")
        }
    </script>
    <style type="text/css">
        #showInfo{
            border: solid 1px;
            width: 200px;
            height: 100px;
        }
    </style>
</head>
<body>
<h3>Ajax demo</h3>
<hr>
<div id="showInfo"></div>
<hr>
<input type="button" value="show info" onclick="getData()"/>
</body>
</html>


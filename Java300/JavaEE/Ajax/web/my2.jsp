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
    <h1>Ajax Demo</h1>
    <hr>
    <input  type="button" value="测试" onclick="getData()">
    <div id="showDiv"></div>

    <script type="text/javascript">
        let div = document.getElementById("showDiv");
        let hello = document.createTextNode("hello World");
        div.appendChild(hello);
        div.style.setProperty("border","solid 1px green");
        div.style.width = "200px";
        div.style.height = "100px";
        function getData() {
            //创建ajax引擎
            let ajax;
            if(window.XMLHttpRequest){ //firefox
                ajax = new XMLHttpRequest();
            }else if(window.ActiveXObject){
                ajax = new ActiveXObject("Msxm12.XMLHTTP")
            }
            //覆写onreadystatement函数
            ajax.onreadystatechange = function(){
                //onreadystatechange是对ajax对象readystate（ajax状态）属性的event
                //readystate会有5种状态
                // 0 - ajax的XMLHttpRequest()对象被实例化
                // 1 - XMLHttpRequest对象被open（）调用，用于创建request（已创建未发送）
                // 2 - XMLHttpRequest对象被send（）调用，其他数据未知
                // 3 - XMLHttpRequest对象已经成功发送，正在接收数据
                // 4 - 表示数据已经成功接收
                if(ajax.readyState === 4) {
                    //获取响应内容
                    if (ajax.status === 200) {
                        let result = ajax.responseText;
                        //alert(result);
                        let showDiv = document.getElementById("showDiv");
                        showDiv.innerHTML = result;

                    }else if (ajax.status === 404) {
                        let showDiv = document.getElementById("showDiv");
                        showDiv.innerHTML = "请求资源不存在";
                    }else if(ajax.status === 500){
                        let showDiv = document.getElementById("showDiv");
                        showDiv.innerHTML = "服务器繁忙";
                    }
                }else {
                    let showDiv = document.getElementById("showDiv");
                    showDiv.innerHTML = "<img src='resources/images/loading.png' width='20%' height='20%'>";
                }
            }
            //发送请求
            ajax.open("get","ajax",true);
            ajax.send(null);
            alert("哈哈");
            //获取元素
            div.appendChild(document.createElement("br"));
            div.appendChild(document.createTextNode("I am from on click getData()"));

        }
    </script>
</body>
</html>

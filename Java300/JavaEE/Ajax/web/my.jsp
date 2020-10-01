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
    <title>Ajax intro</title>
</head>
<body>
    <h1>Test Ajax</h1>
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
            div.appendChild(document.createElement("br"));
            div.appendChild(document.createTextNode("I am from on click getData()"));

        }
    </script>
</body>
</html>

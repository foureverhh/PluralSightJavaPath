<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-06-02
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Ajax learning</title>
    <script type="text/javascript">
        function getData(){
            let info = document.getElementById("showInfo");
            info.innerHTML = "哈哈，今天的雾霾真的是新鲜！"
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

<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-06-04
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax XML trans</title>
    <script type="text/javascript">
        let ajax = new XMLHttpRequest();
        //let showInfo = document.getElementById("showInfo");
        function getXML(){
            ajax.onreadystatechange = ()=>{
                if(ajax.readyState===4 && ajax.status === 200){
                    let response = ajax.responseXML;
                    alert(response.getElementsByTagName("name")[0].innerHTML)
                    //showInfo.innerHTML = response;
                }
            }
            ajax.open("GET","xml.jsp");
            ajax.send(null);
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
<h3>ajax xml demo</h3>
<hr>
<input type="button" value="XML" onclick="getXML()">
<hr>
<div id="showInfo"></div>
</body>
</html>

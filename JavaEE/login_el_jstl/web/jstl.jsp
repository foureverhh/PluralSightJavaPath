<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-06-06
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp standard tag library</title>
    <script type="text/javascript">
        function login(){
            let name = document.getElementById("name").value;
            let pwd = document.getElementById("pwd").value;
            let ajax = new XMLHttpRequest();
            ajax.onreadystatechange = function () {
                if(ajax.readyState === 4 && ajax.status === 200){
                    let resultZone = document.getElementById("result");
                    resultZone.innerHTML = "";
                    let responseText = ajax.responseText;
                    JSON.parse(responseText,(key,value)=>{
                        if(key.length>0){
                            resultZone.append(value + "\n")
                        }
                    });
                }
            }
            ajax.open("get","/login/user" + "?name="+name+"&pwd="+pwd);
            ajax.send(null);
        }

    </script>
</head>
<body>
    <h3>login -jsp standard tag library</h3>
<%--    <form action="#" method="get">--%>
        <table border="1px">
            <tr>
                <td>Name:</td>
                <td><input type="text" id="name" name="name" placeholder="name"></td>
            </tr>
            <tr>
                <td>pwd:</td>
                <td><input type="password" id="pwd" name="pwd" placeholder="password"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center">
                    <input type="button" value="log in" onclick="login()">
                </td>
            </tr>
        </table>
<%--    </form>--%>
    <div id="result">
    </div>
</body>
</html>

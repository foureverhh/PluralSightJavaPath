<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-06-03
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax Data</title>
    <script type="text/javascript">
        function getData() {
            //user inquiry info
            let name = document.getElementById("name").value;
            alert(name)
            //set up ajax instance
            let ajax = new XMLHttpRequest();
            //override onreadystatechange
            ajax.onreadystatechange = () => {
                if(ajax.readyState === 4 && ajax.status === 200) {
                    let userFound = ajax.responseText;
                    alert(userFound)
                    let tr = document.createElement("tr");
                    JSON.parse(userFound, (key, value) => {
                        if (key !== "") {
                            let td = document.createElement("td");
                            td.append(value);
                            tr.append(td);
                        }
                    })
                    if (document.getElementById("userTable").rows.length > 1) {
                        document.getElementById("userTable").deleteRow(1);
                    }
                    document.getElementById("userTable").append(tr);
                }
            }
            //send request
            ajax.open("GET","user?name=" + name);
            ajax.send(null);
        }
    </script>
</head>
<body>
    <h3>英雄商店</h3>
        英雄名称： <input type="text" id="name" value=""> &nbsp <input type="button" value="search" onclick="getData()">
    <hr>
    <table border="1px" id="userTable">
        <tr>
            <td>编号：</td>
            <td>名称：</td>
            <td>价格：</td>
            <td>位置：</td>
            <td>描述：</td>
        </tr>
    </table>
</body>
</html>

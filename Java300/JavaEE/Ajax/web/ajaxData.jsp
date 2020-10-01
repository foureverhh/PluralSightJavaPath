<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-04-03
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
    <h3>欢迎访问英雄商店</h3>
    <hr>
    <label for="name"> 英雄名称：</label>
    <input type="text" name="name" id="name" value=""/>
    <br>
    <input type="button" value="搜索" onclick="getData()"/>
    <hr>
    <table border="1px">
        <tr>
            <td>编号</td>
            <td>名称</td>
            <td>价格</td>
            <td>位置</td>
            <td>描述</td>
        </tr>
    </table>
    <script>
       /*let obj = { }; //通过eval将来实现将java对象user封装为js对象user*/
       /*let obj; //通过json声明格式以及eval来将java对象user封装为js对象user*/
        function getData()
        {
            let ajax;
            if(window.XMLHttpRequest)
            {
                ajax = new XMLHttpRequest();
            }
            else if(window.ActiveXObject)
            {
                ajax = new ActiveXObject("Msxm12.XMLHTTP");
            }

            let name = document.getElementById("name").value;

            if (name == null)
            {
                document.getElementsByTagName("body").insertBefore(
                    document.createTextNode("Error"),
                    document.getElementsByName("table")[0]);
            }
            else
            {
                ajax.onreadystatechange = function ()
                {

                    if (ajax.readyState === 4)
                    {
                        if (ajax.status === 200)
                        {
                            /*
                               //1.通过操作node实现
                               let response = ajax.responseText;
                               let table = document.getElementsByTagName("table")[0];
                               table.style.border = "3px red dotted";
                               let tr = document.createElement("tr");
                               tr.innerHTML = response;
                               table.appendChild(tr);
                            */

                            /*
                            //通过eval将来实现将java对象user封装为js对象user
                               let response = ajax.responseText;
                               eval(response);//将response中的string转化为js object
                               alert(obj.name);
                            */


                 /*
                            //通过json声明格式以及eval来将java对象user封装为js对象user
                                 let response = ajax.responseText;
                                 eval("obj = "+ response);
                                 alert(obj.name);
                                 */

                            //通过Gson.toJson(obj)
                            let response = ajax.responseText;
                            alert(response);
                            eval("let user =" + response);
                        }

                    }
                };
                ajax.open("get", "user?name=" + name);
                ajax.send(null);
            }
        }
    </script>
</body>
</html>

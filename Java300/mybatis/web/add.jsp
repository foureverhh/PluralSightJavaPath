<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-06-09
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">
        //相当于window.onload=function(){} 或者 $(document).ready=()=>{}
        $(function () {
            $("form").submit(()=>{
                if($(":text:eq(0)").val()==""||$(":text:eq(1)").val()==""||$(":text:eq(2)").val()==""){
                    alert("表单内容不能为空")
                    return false;
                }
            })
        })
    </script>
</head>
<body>
    <h3>花卉信息</h3>
    <%--
    post:字节流 2G 更安全 相对效率低
    get: 字符流 2kb 不安全 效率高
    --%>
    <form action="insert" method="post">
        <table>
            <tr>
                <td>花卉名称：</td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>花卉价格：</td>
                <td><input type="text" name="price"/></td>
            </tr>
            <tr>
                <td>花卉产地：</td>
                <td><input type="text" name="production"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="submit"></td>
                <td><input type="reset" value="reset"></td>
            </tr>
        </table>
    </form>
</body>
</html>

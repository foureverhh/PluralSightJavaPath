<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-07-08
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            let username = false;
            let password = false;
            let pwdMatch = false;
           /* $(":text:eq(0)").on('blur',()=>{*/
            let $username = $(":input[name='username']");
            let $password = $(":input[name='password']");
            let $pwd = $(":input[name='pwd']");
            let $file = $(":input[name='file']");
            //用户名的验证
            $username.on('blur',function(){
                if($(this).val()==""){
                    $(this).next().css("color","red").html("X");
                    username = false;
                }else {
                    $(this).next().css("color","green").html("√");
                    username = true;
                }
            });
            //密码的验证
            $password.on('blur',function(){
                if($(this).val().match(/^\w{6,12}$/)){
                   $(this).next().css("color","green").html("√");
                   password = true;
                }else {
                    $(this).next().css("color","red").html("X");
                    password = false;
                }
            });

            //确认密码验证
            $pwd.on('blur',function () {
                if($(this).val() != $password.val() || $(this).val()==""){
                    $(this).next().css('color','red').html("X");
                    pwdMatch = false;
                }else {
                    $(this).next().css("color","green").html("√");
                    pwdMatch = true;
                }
            })

            //文件域非空验证
            $(":submit").click(function(e){
                if(username && password && pwdMatch && $file.val() != ""){
                    $(this).parent().submit();
                }else {
                    e.preventDefault();
                    alert("You have error field to fill")
                }
            });
        })
    </script>

</head>
<body>
    <h3>Registration</h3>
    <form action="${pageContext.request.contextPath}/reg" enctype="multipart/form-data" method="post">
        用户名：&nbsp;<input type="text" name="username" id="username"><span></span>
        <br>
        密码：&nbsp;&nbsp;<input type="password" name="password"/><span></span>
        <br>
        确认密码：<input type="password" name="pwd"><span></span>
        <br>
        头像：&nbsp;&nbsp;<input type="file" name="file">
        <br>
        <input type="submit" value="注册">
    </form>
</body>
</html>

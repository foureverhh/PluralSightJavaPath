<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-06-01
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(()=>{
            $("#fm").submit(function () {
                let newPwd = $("#newPwd").val();
                let cfPwd = $("#cfPwd").val();
                if(newPwd===""){
                    alert("new password is empty!" + newPwd + " , " +cfPwd);
                    return false;
                }
                if(cfPwd===""){
                    alert("confirm password is empty!" + newPwd + " , " +cfPwd);
                    return false;
                }
                if(newPwd===cfPwd){
                    return true;
                }else {
                    alert("password not same" + newPwd + " , " +cfPwd);
                    return false;
                }

            })
        });
    </script>
</head>

<body>

    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="#">首页</a></li>
            <li><a href="#">个人信息</a></li>
            <li><a href="#">修改密码</a></li>
        </ul>
    </div>

    <div class="formbody">

        <div class="formtitle"><span>徐改密码信息</span></div>
        <form action="/info/user/demo" method="post" id="fm" target="_top">
            <input type="hidden" name="oper" value="resetPwd">
            <ul class="forminfo">
                <li><label>新密码</label><input name="newPwd" id="newPwd" type="text" class="dfinput" /><i></i></li>
                <li><label>确认密码</label><input name="" id="cfPwd" type="text" class="dfinput" /><i></i></li>
                <li><input name="" type="submit" class="btn" value="确认保存"/></li>
            </ul>
        </form>
    </div>


</body>

</html>

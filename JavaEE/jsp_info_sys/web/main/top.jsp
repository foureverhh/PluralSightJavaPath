<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-05-31
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ page import="pojo.User"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="../js/jquery.js"></script>
    <script type="text/javascript">
        $(function(){
            //顶部导航切换
            $(".nav li a").click(function(){
                $(".nav li a.selected").removeClass("selected")
                $(this).addClass("selected");
            })

            $("#logout").click(()=>{
                let flag = window.confirm("Are you sure to log out?");
                //alert(flag);
                if(flag){
                    //send request
                   //window.location.href="http://localhost:8080/info/user/info?oper=logout";
                    //向浏览器的top location发起request
                    window.top.location.href="http://localhost:8080/info/user/demo?oper=logout";

                }
            })
            window.close = ()=>{
                window.top.location.href="http://localhost:8080/info/user/demo?oper=logout";
            }
        })

    </script>
</head>

<body style="background:url(../images/topbg.gif) repeat-x;">

    <div class="topleft">
        <a href="main.html" target="_parent"><img src="images/logo.png" title="系统首页" /></a>
    </div>

    <div class="topright">
        <ul>
            <li><a href="javascript:void(0)" id="logout" >退出</a></li>
            <li>当前在线人数<span> ${applicationScope.counter}</span></li>
        </ul>
        <div class="user">
            <span>${sessionScope.user.uname}</span>
        </div>
    </div>

</body>
</html>


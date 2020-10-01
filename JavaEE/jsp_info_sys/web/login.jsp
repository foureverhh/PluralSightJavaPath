<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-05-30
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>欢迎登录后台管理系统</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="js/jquery.js"></script>
    <script src="js/cloud.js" type="text/javascript"></script>

    <script language="javascript">
        $(function(){
            $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            $(window).resize(function(){
                $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            })
        });
    </script>

</head>

<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
    <span>欢迎登录后台管理界面平台</span>
    <ul>
        <li><a href="#">回首页</a></li>
        <li><a href="#">帮助</a></li>
        <li><a href="#">关于</a></li>
    </ul>
</div>

<div class="loginbody">
  <%--  <c:if test="${flag==0}">
        <span>用户名或者密码错误</span>
        <c:set var="flag" value="" scope="request"/>
    </c:if>--%>
    <c:choose>
        <c:when test="${requestScope.flag == 0}">
            <span>用户名或者密码错误</span>
        </c:when>
        <c:when test="${sessionScope.flag == 1}">
            <span>密码修改成功，请重新登录</span>
        </c:when>
        <c:when test="${sessionScope.flag == 2}">
            <span>欢迎新用户登录！</span>
        </c:when>
    </c:choose>
      <c:remove var="flag"/>
<%--    <span class="systemlogo">  </span>
    <%
        Object obj = request.getAttribute("flag");

        if(obj!=null){
    %>
    <div style="text-align: center">
        <span>用户名或者密码错误</span>
    </div>
    <%
        }
    %>--%>

 <%--   <%
        Object pwd = session.getAttribute("pwdReset");

        if(pwd!=null){
    %>
    <div style="text-align: center">
        <span>密码修改成功，请重新登录</span>
    </div>
    <%
        }
        session.removeAttribute("pwdReset");
    %>--%>
<%--    <%
        Object newMember = session.getAttribute("succeedRegistered");
        if(newMember!=null){
    %>
        <span>欢迎新用户登录！</span>
    <% }
        session.removeAttribute("succeedRegistered");%>
        --%>
    <div class="loginbox loginbox1">
        <form action="user/demo" method="post">
            <input type="hidden" name="oper" value="login"/>
            <ul>
                <li><input name="uname" type="text" class="loginuser"  placeholder="用户名"/></li>
                <li><input name="pwd" type="text" class="loginpwd" placeholder="密码"/></li>
                <li class="yzm">
                    <span><input name="" type="text" value="验证码" onclick="this.value=''"/></span><cite>X3D5S</cite>
                </li> <%-- --%>
                <li><input name="" type="submit" class="loginbtn" value="登录"  /><label><a href="/info/user/registration.jsp">注册</a></label><label><a href="#">忘记密码？</a></label></li>
            </ul>
        </form>
    </div>

</div>


<div class="loginbm">版权所有  2014  <a href="http://www.uimaker.com">uimaker.com</a>  仅供学习交流，勿用于任何商业用途</div>


</body>

</html>

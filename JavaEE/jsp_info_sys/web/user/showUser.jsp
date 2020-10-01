<%@ page import="java.util.List" %>
<%@ page import="pojo.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>userInfo</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../js/jquery.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){
            $(".click").click(function(){
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function(){
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function(){
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function(){
                $(".tip").fadeOut(100);
            });

        });
    </script>


</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">用户信息</a></li>
        <li><a href="#">全部用户信息</a></li>
    </ul>
</div>

<div class="rightinfo">
    <table class="tablelist">
        <thead>
        <tr>
            <th>用户ID<i class="sort"><img src="../images/px.gif" /></i></th>
            <th>用户名</th>
            <th>密码</th>
            <th>性别</th>
            <th>年龄</th>
            <th>出生年月</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.allUsers}"  var="user">
            <tr>
                <th>${user.uid}</th>
                <th>${user.uname}</th>
                <th>${user.pwd}</th>
        <%--        <c:if test="${user.sex == 1}"><th>男</th></c:if>
                <c:if test="${user.sex == 2}"><th>女</th></c:if>--%>
                <th>${user.sex == 1?'男':'女'}</th>
                <th>${user.age}</th>
                <th>${user.birth}</th>
            </tr>
        </c:forEach>
  <%--
        <%
            List<User> users = (ArrayList<User>) request.getAttribute("allUsers");
            for(User u:users){
        %>
        <tr>
            <td><%=u.getUid()%></td>
            <td><%=u.getUname()%></td>
            <td><%=u.getPwd()%></td>
            <td><%=u.getSex()%></td>
            <td><%=u.getAge()%></td>
            <td><%=u.getBirth()%></td>
        </tr>
        <%}%>
        --%>
        </tbody>
    </table>
    <div class="tip">
        <div class="tiptop"><span>提示信息</span><a></a></div>

        <div class="tipinfo">
            <span><img src="images/ticon.png" /></span>
            <div class="tipright">
                <p>是否确认对信息的修改 ？</p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
            </div>
        </div>

        <div class="tipbtn">
            <input name="" type="button"  class="sure" value="确定" />&nbsp;
            <input name="" type="button"  class="cancel" value="取消" />
        </div>

    </div>




</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>

</body>

</html>


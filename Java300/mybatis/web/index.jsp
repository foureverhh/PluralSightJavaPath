<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-05-05
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/htm;charset=utf-8">
    <title>Title</title>
    <style type="text/css">
        a{
            color:black;
            text-decoration: none;
            border: 5px solid bisque;
        }
        a:hover{
            color:red;
            border: 5px dotted mediumvioletred;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <td>花卉编号</td>
            <td>花卉名称</td>
            <td>价格（元）</td>
            <td>原产地</td>
        </tr>

        <c:forEach items="${requestScope.list}" var="flower">
            <tr>
                <td>${flower.id}</td>
                <td>${flower.name}</td>
                <td>${flower.price}</td>
                <td>${flower.production}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="add.jsp">添加花卉</a>
    <p>
        <c:if test="${sessionScope.insert}">
            new follower inserted
            <c:remove var="insert" scope="session"/>
        </c:if>
    </p>
</body>
</html>

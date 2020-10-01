<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-08-10
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
    <h3>Name List</h3>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>age</th>
        </tr>
    <c:forEach items="${requestScope.users}" var="user">
        <tr>
            <td>${user.userId}</td>
            <td>${user.username}</td>
            <td>${user.userAge}</td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>

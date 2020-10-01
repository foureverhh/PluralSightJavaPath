<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-07-02
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>main</h3>
    <p><c:out value="${peo.name}"/></p>
    <p><c:out value="${peo.age}"/></p>
    <p><c:out value="${peo.age}"/></p>
    <p>${requestScope.demo123}</p>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-07-07
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>
    <h3>main.jsp</h3>
    <p>${requestScope.req}</p>
    <p>${sessionScope.session1}</p>
    <p>${sessionScope.session2}</p>
    <p>${applicationScope.application}</p>
</body>
</html>

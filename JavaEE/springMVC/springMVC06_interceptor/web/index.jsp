<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-07-08
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index</title>
  </head>
  <body>
    <%System.out.println("index page");%>
    <p>${requestScope.model}</p>
    <p>count: ${sessionScope.count}</p>
  </body>
</html>

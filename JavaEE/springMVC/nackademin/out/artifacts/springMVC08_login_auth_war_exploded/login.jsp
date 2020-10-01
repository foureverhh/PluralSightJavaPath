<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-07-10
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>login</title>
  </head>
  <body>
    <h3>login page</h3>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input type="text" name="username"/> <br>
        密  码：<input type="password" name="password"/> <br>
        <input type="submit" value="登录">
    </form>
  </body>
</html>

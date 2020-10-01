<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-06-12
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>transfer</title>
  </head>
  <body>
  <form action="transfer" method="post">
        转账账户:&nbsp&nbsp&nbsp&nbsp<input type="text" name="senderAccNo"><br>
        转账账户密码： <input type="password" name="senderPassword"><br>
        转账金额：&nbsp&nbsp&nbsp&nbsp <input type="text" name="senderBalance"><br>
        收款转账账户： <input type="text" name="receiverAccNo"><br>
        收款账户姓名： <input type="text" name="receiverName"><br>
        <input type="submit" value="转账">
  </form>
  <h3>create no log:</h3>
  <form action="insert" method="post">
        转账账户:&nbsp&nbsp&nbsp&nbsp<input type="text" name="accOut"><br>
        转账金额：&nbsp&nbsp&nbsp&nbsp <input type="text" name="money"><br>
        收款转账账户： <input type="text" name="accIn"><br>
        <input type="submit" value="create">
  </form>
  </body>
</html>

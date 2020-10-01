<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-05-31
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>信息系统管理界面</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
</head>
    <frameset rows="88,*,31" cols="*" frameborder="no" border="0" framespacing="0">
        <frame src="top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
        <frameset cols="187,*" frameborder="no" border="0" framespacing="0">
            <frame src="left.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame" />
            <frame src="right.jsp" name="rightFrame" id="rightFrame" title="rightFrame" />
        </frameset>
        <frame src="footer.jsp" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame" title="bottomFrame" />
    </frameset>
    <noframes>
<body>

</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-06-12
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>log</title>
</head>
<body>
    <h3>transfer success!</h3>
    <table>
        <tr>
            <th>id</th>
            <th>Sender account</th>
            <th>Receiver account</th>
            <th>Amount</th>
        </tr>
        <c:forEach items="${requestScope.currentPageInfo.currentPage}" var="log">
            <tr>
                <td>${log.id}</td>
                <td>${log.accOut}</td>
                <td>${log.accIn}</td>
                <td>${log.money}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/bank/log?pageNumber=${requestScope.currentPageInfo.pageNumber-1}&pageSize=${requestScope.currentPageInfo.pageSize}"
            <c:if test="${requestScope.currentPageInfo.pageNumber <=1}">
                onclick="javascript:return false;"
            </c:if>
    >
        上一页
    </a>
    <a href="/bank/log?pageNumber=${requestScope.currentPageInfo.pageNumber+1}&pageSize=${requestScope.currentPageInfo.pageSize}"
            <c:if test="${requestScope.currentPageInfo.pageNumber >= requestScope.currentPageInfo.totalPages}">
                onclick="javascript:return false;"
            </c:if>
    >下一页</a>
</body>
</html>

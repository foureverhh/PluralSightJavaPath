<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-07-08
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
    <script src="js/jquery-3.5.1.js"></script>
    <script>
        $(function(){
            $("a").on('click',function(){
                let $td = $(this).parent().prev();
                $td.html(parseInt($td.html())+1);
            });
        })
    </script>
</head>
<body>
    <h3>This is main</h3>
    <table border="1">
        <tr>
            <th>资料名称</th>
            <th>下载次数</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${requestScope.files}" var="file">
            <tr>
                <td>${file.name}</td>
                <td>${file.count}</td>
                <td><a href="${pageContext.request.contextPath}/download?file=${file.name}&id=${file.id}">下载</a></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>

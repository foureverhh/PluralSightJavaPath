<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-07-21
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>test1</h3>
    <dl>
        <c:forEach items="${sessionScope.user.menus}" var="menu">
            <dt>${menu.name}

                    <c:forEach items="${menu.children}" var="sub">
                            <dd>${sub.name}</dd>
                    </c:forEach>

            </dt>
        </c:forEach>
    </dl>
    <hr/>
    <p><i>length of elements:</i> ${fn:length(sessionScope.user.elements)}</p>
    <c:forEach items="${sessionScope.user.elements}" var="ele">
        <p>I am here</p>
        <c:if test="${ele.eleno == 'grant'}">
            <button>授权</button>
        </c:if>
    </c:forEach>
    <button>新建</button>
</body>
</html>

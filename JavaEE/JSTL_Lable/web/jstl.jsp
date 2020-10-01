<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--

  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-06-06
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL-使用标签完成逻辑</title>
</head>
<body>
    <ul>
        <li>核心标签库</li>
        <ul>
            <li>导入jar包</li>
            <li>c:out value=""标签
                声明jstl标签库的引入（核心标签库）<br>
                <%--
                <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
                --%>
            </li>
            <li>c:set var value标签</li>
            <li>c:remove var scope</li>
            <li>c:set c:if</li>
            <li>c:foreach begin= end= step= varStatus=vs</li>
                <ul>
                    <li>vs.index</li>
                    <li>vs.count</li>
                    <li>vs.first</li>
                    <li>vs.last</li>
                </ul>
            <li>c:foreach items= var=</li>
                <ul>
                    <li>items 声明要遍历的表格,结合EL表达式</li>
                    <li>var 声明变量，记录每次循环的结果。结果存储在作用域中，需要使用el表达式来获取</li>
                </ul>
        </ul>
        <li>格式化标签库</li>
        <li>sql标签库</li>
        <li>函数标签库</li>
        <li>XML标签库</li>
    </ul>
    <hr>
     <h3>demo</h3>
    <%request.setAttribute("str","Good day to study!");%>
    <c:out value="${str}"/> <br>
    <c:out value="${str2}" default="default value"/>
    <c:set var="hello" value="hello pageContext" scope="page"/>
    <c:set var="hello" value="hello request" scope="request"/>
    <c:set var="hello" value="hello session" scope="session"/>
    <c:set var="hello" value="hello application" scope="application"/>
    <c:out value="${sessionScope.hello}"/>
    <c:remove var="hello" scope="page"/> <br>
    <c:out value="${hello}"/>

    <h3>逻辑判断</h3>
    <%
        int a =4;
        if(a>3){
        %>
        <p>天气真好</p>
    <%}%>
    <c:set var="a" value="4"/>
    <c:if test="${a>3}">
        <p>天气真好</p>
    </c:if>

    <c:set var="score" value="85"/>
    <c:choose>
        <c:when test="${score >= 90}">
            <i>奖励吃鸡装备</i>
        </c:when>
        <c:when test="${score < 90 && score >= 80}">
            <i>奖励空投箱</i>
        </c:when>
        <c:when test="${score <80 && score >= 70}">
            <i>无奖励，无惩罚</i>
        </c:when>
        <c:otherwise>
            <i>男女混合双打</i>
        </c:otherwise>
    </c:choose>

    <hr>
    <h3>jstl循环</h3>
    <label>常数循环</label>
    <c:forEach begin="1" end="4" step="1" varStatus="vs">
        <c:if test="${vs.count==2}">
            2222 <br>
        </c:if>
        ${vs.index} -- ${vs.count} -- ${vs.first} -- ${vs.last}
        <br>
        <%--循环体--%>
    </c:forEach>
    <hr>
    <%
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        request.setAttribute("list",list);
    %>
    <label>动态循环</label>
    <p>list demo</p>
    <c:forEach items="${list}" var="str">
        ${str} <br>
    </c:forEach>
    <%
        Map<String,String> map = new HashMap<String,String>();
        map.put("a1","哈哈");
        map.put("a2","嘿嘿");
        request.setAttribute("map",map);
    %>
    <p>map demo</p>
    <c:forEach items="${map}" var="word">
        ${word.key} -- ${word.value} <br>
    </c:forEach>



</body>
</html>

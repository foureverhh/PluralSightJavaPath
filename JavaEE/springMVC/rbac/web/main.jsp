<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-07-06
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
<script src="${pageContext.request.contextPath}/js/query-3.5.1.js"></script>
<script>
    $(function(){
        $.post("getMenu",function (data) {
            alert(JSON.stringify(data))
            let menu = "";
            let result = getAllMenu1(data)
            menu += "<ul>"+result+"</ul>"
            console.log("menu: "+menu)
            $("#menu").html(menu);
        })

    })

    let getAllMenu1 =  function (data){
        //alert(data)
        //if(!data){
        if(data.length === 0){
            return "";
            //return result;
        }
        let result = "";
        for (let i =0; i < data.length; i++) {
            if(data[i].children.length >0){
                result += "<li>"+ data[i].name+"<ul>" + getAllMenu1(data[i].children) + "</ul></li>"
                console.log(">"+result)
               // return getAllMenu1(data[i].children);
            }else {
                result += "<li>" + data[i].name + "</li>"
                console.log("》" + result)
               // return getAllMenu1(data[i].children);
            }
        }
        return result;
    }
</script>
--%>
<html>
<head>
    <title>main</title>
</head>
<body>
    <h3>Hello ${sessionScope.user.username}</h3>
   <%-- <div id="menu"></div>--%>
    <dl>
        <c:forEach items="${sessionScope.user.menus}" var="menu">
            <dt>${menu.name}

            <c:forEach items="${menu.children}" var="sub">
                <dd>${sub.name}</dd>
            </c:forEach>

            </dt>
        </c:forEach>
    </dl>
    <c:forEach items="${sessionScope.user.elements}" var="ele">
        <c:if test="${ele.eleno eq 'grant'}">
            <button >授权</button>
        </c:if>
    </c:forEach>
        <button>新增</button>
</body>
</html>

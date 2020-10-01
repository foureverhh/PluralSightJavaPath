<%@ page import="com.foureverhh.pojo.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-06-05
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%--使用el可以实现获取请求参数param，获取请求作用域attribute--%>
<%--el可以获取pageContext,requeset,session,application四个对象中的数据，其他数据一概不理会
    找到了数据则返回，找不到则什么都不做，也不报错--%>
<%--语法：
    ${表达式}，使用.和[]两中运算符来 存取 数据！
         表达式：
           获取请求数据：
                request对象存储了请求数据->param.键名  返回值
                request对象存储了请求数据->paramValues.键名  返回数组
           通过作用域，setAttribute方法存储到作用域中的数据
                ${键名} 返回键名所对应的值
                注意：
                    如果存储的是普通字符串则直接返回
                    如果存储的是对象，则返回的是对象
                        获取返回对象中的数据：
                            普通对象：
                                ${键名.属性名.属性名}
                            集合对象：
                                list集合->${键名[index]} list底层是通过array实现的
                                map集合->${键名.map集合存储的键名}

                                ${逻辑表达式}：&& || !
                                ${算数表达式}： + - * /
                                ${关系表达式}: <,>,>=,<=, %
                                特殊： 三目运算

                            空值判断:
                                ${empty 键名}
                                判断键名对象是否存在数据
                                ""为true
                                new User()为false
                                new ArrayList()为true
                                new HashMap() 为true

                            EL获取请求头数据和cookie数据
                                请求头数据：
                                    ${header} --> 返回所有的请求头数据
                                    ${header["键名"]} --> 放回指定键名的请求头数据
                                    ${haederValues["键名"]} --> 返回指定键名（同键不同值）的值的数组
                                获取Cookie:
                                ${cookie} --> 返回存储了所有cookied对象的map集合
                                ${cookie.JSESSIONID} --> 返回指定的cookie对象
                                ${cookie.键名.cookie存储数据的键名} --> 返回指定的cookie对象存储的数据的
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>EL jsp</title>
    </head>
    <body>
        <h1>EL</h1>
        <hr>
        <h3>request 作用域</h3>
        <b><%=request.getParameter("name")%></b><br>
        <b><%=request.getParameter("pwd")%></b><br>
        <b><%=request.getAttribute("str")%></b><br>
        <b><%=((User)request.getAttribute("user")).getAddr().getTown()%></b><br>
        <b><%=((List<String>)request.getAttribute("list")).get(2)%></b><br>
        <b><%=((User)((List<User>)request.getAttribute("list2")).get(0)).getAddr().getCity()%></b><br>

        <b><%=((Map<String,String>)request.getAttribute("map")).get("a")%></b><br>
        <b><%=((User)((Map<String,User>)request.getAttribute("map2")).get("a1")).getAddr().getCity()%></b><br>

        <hr>
        <h3>el,使用EL表达式获取作用域对象数据</h3>
        <p>获取请求参数:  <span>${param.name}</span></p>
        <p>获取请求参数:  <span>${paramValues.fav[0]}</span></p>
        <p>获取请求作用域： <span>${str}</span></p>
        <p>获取请求作用域： <span>${user.addr.town}</span></p>
        <p>获取请求作用域： <span>${list[2]}</span></p>
        <p>获取请求作用域： <span>${list2.get(0).addr.city}</span></p>
        <p>获取请求作用域： <span>${map.a}</span></p>
        <p>获取请求作用域： <span>${map2.get("a1").addr.city}</span></p>

        <hr>
        <h3>el 作用域查找顺序</h3>
        <%  //默认查找顺序，从作用域最小的到最大的 pageContext -> request -> session -> application
            application.setAttribute("hello","hello application");//作用域为在服务器上运行的application
            session.setAttribute("hello","hello session");        //作用域本user的session
            request.setAttribute("hello","hello request");        //作用域本request
            pageContext.setAttribute("hello","hello pageContext");//作用域只是本页
        %>
        <%--从request中查找--%>
        <p>${requestScope.hello}</p>
        <p>${pageScope.hello}</p>
        <p>${sessionScope.hello}</p>
        <p>${applicationScope.hello}</p>
        <hr>
        <h3>EL表达式的逻辑运算</h3>
        <p>${1+2} -- ${1*2} -- ${4/2} -- ${4%3} -- ${4==4} -- ${4>2} -- ${1==1? '男':'女'}</p>

        <hr>

        <h3>EL的空值判断</h3>
        <p>${empty s} -- ${empty s1} -- ${empty s2} -- ${empty s3}</p>

        <hr>
        <h3>EL获取请求头数据</h3>
        <p>${header}</p>
        <p>${header["user-agent"]}</p>
        <p>${headerValues["accept-language"][0]}</p>
        <hr>
        <h3>cookies数据</h3>
        <p>${cookie}</p>
        <p>${cookie.JSESSIONID}</p>
        <p>${cookie.JSESSIONID.name}</p>
        <p>${cookie.JSESSIONID.value}</p>
    </body>
</html>

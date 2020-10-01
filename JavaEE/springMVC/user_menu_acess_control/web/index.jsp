<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-07-06
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
<%--    <script src="${pageContext.request.contextPath}/js/query-3.5.1.js"></script>
    <script>
      $(function(){
          $.post("${pageContext.request.contextPath}/show",(data)=>{
            let result = "";
            for (let i = 0; i < data.length ; i++) {
                result+="<dl>"
                result+="<dt style='cursor: pointer'>"+ data[i].name +"</dt>"
                for(let j=0; j<data[i].children.length;j++){
                  result+="<dd>"+ data[i].children[j].name +"</dd>"
                }
                result+="</dl>"
            }
            $("#menu").html(result)
            $("dt:first").on('click',function(){
              $(this).css("border","1px red dotted")
              $(this).siblings().toggle(500);
            });

            $("dt:last").on('click',function(){
              $(this).css("border","1px red dotted")
              $(this).siblings().toggle(500);
            });
          });
      })
    </script>--%>
  </head>
  <body>
      <h3>Log in</h3>
      <form action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input type="text" name="username"/> <br>
        密  码：<input type="password" name="password"/> <br>
        <input type="submit" value="Login"/>
      </form>
        <div id="menu"></div>
  </body>
</html>

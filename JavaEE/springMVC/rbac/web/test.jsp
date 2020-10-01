<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-07-16
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
    <script src="${pageContext.request.contextPath}/js/query-3.5.1.js"></script>
    <script>
        $(function(){
            $.post("${pageContext.request.contextPath}/getMenu",
                (data)=>{
                    alert(data)
                    let result = "";
                    for (let i = 0; i < data.length ; i++) {
                        alert("data[i]->"+data[i])
                        alert("data[i].children->"+data[i].children)
                        result+="<dl>"
                        result+="<dt style='cursor: pointer'>"+ data[i].name +"</dt>"
                        for(let j=0; j<data[i].children.length;j++){
                            result+="<dd>"+ data[i].children[j].name +"</dd>"
                        }
                        result+="</dl>"
                    }
                    $("body").html(result)
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
    </script>
</head>
<body>
$END$
</body>
</html>

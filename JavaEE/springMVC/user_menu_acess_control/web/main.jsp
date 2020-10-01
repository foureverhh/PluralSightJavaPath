<%--
  Created by IntelliJ IDEA.
  User: foureverhh
  Date: 2020-07-06
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="${pageContext.request.contextPath}/js/query-3.5.1.js"></script>
<script>
    $(function(){
        $.post("getMenu",function (data) {
            let menu = "";
            //alert(data)
        /*    for (let i = 0; i < data.length; i++) {
                result += "<dl>"
                //result += data[i].name
                alert("data[i]->"+data[i])
                alert("data[i].children->"+data[i].children)
                result += "</dl>"
            }*/
            //let result = getAllMenu(menu, data)
            let result = getAllMenu1(data)
            menu += "<ul>"+result+"</ul>"
            console.log("menu: "+menu)
            $("#menu").html(menu);
        })

    })
/*
    let getAllMenu =  function (result, data){
        //alert(data)
        //if(!data){
        if(data.length === 0){
            console.log(result)
            return result;
            //return getAllMenu(result,data[i].children);
        }
        for (let i =0; i < data.length; i++) {
            if(data[i].children.length >0){
                result += "<li>"+ data[i].name+"<ul>" + getAllMenu(result,data[i].children) + "</ul></li>"
                console.log(">"+result)
            }else {
                result += "<li>" + data[i].name + "</li>"
                console.log("》" + result)
            }
        }
    }*/

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
 /*   let getAllMenu =  function (result, item){
        alert(item)
        if(item === ""){
            return ;
        }
        for (let i =0; i < item.length; i++) {
            if (item[i].children != "") {
                result += "<dt>"
                result += item[i].name
                result += "</dt>"
                getAllMenu(result,item[i].children)
            } else {
                result += "<dd>"
                result += item[i].name
                result += "</dd>"
            }
        }
    }*/
</script>
<html>
<head>
    <title>main</title>
</head>
<body>
    <h3>Main page</h3>
    <div id="menu"></div>
</body>
</html>

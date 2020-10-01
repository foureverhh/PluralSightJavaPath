package com.foureverhh.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
* 过滤器的使用：
*    作用：
*       对服务器请求的资源和响应给浏览器的资源进行管理
*       保护servlet
*
*    使用：
*       创建一个实现了Filter接口的普通java类
*       覆写接口的方法
*          init方法:服务器启动即执行
*          doFilter方法:过滤请求的方法，在此方法中需要手动放行filterChain.doFilter(request,response);
*          destroy方法：服务器关闭执行
*
*    在web.xml中配置过滤器
*    <filter>
*       <filter-name>myFilter</filter-name>
*        <filter-class>com.foureverhh.filter.MyFilter</filter-class>
*   </filter>
*    <filter-mapping>
*       <filter-name>myFilter</filter-name>
*        <url-pattern>/*</url-pattern>
*    </filter-mapping>
*
*    过滤器的生命周期：
*        服务器开始到关闭
*    总结：
*        过滤器程序员声明和配置，服务器根据请求中的uri信息调用
*    执行：
         浏览器发起请求到服务器，服务器接收到请求后，根据URI信息在web.xml中找到对应的过滤器执行doFilter方法，
         该方法对此次请求进行处理后如果符合要求则放行，放行后如果还有符合要求的过滤则继续执行过滤，找到执行对应的
         servlet进行请求处理。
         servlet对请求处理完毕后，也就service方法结束了。还需要继续返回对应的doFilter方法继续执行。

     案例：
        统一编码格式设置
        session管理
        权限管理
        资源管理（加水印）
 */

//@WebFilter("/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter.init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我是第一个filter，我被执行了");
        //设置request及response的编码格式
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");

        //判断session是否存在
        HttpSession hs = ((HttpServletRequest) servletRequest).getSession();
        //判断session中是否有user信息
        if(hs.getAttribute("user")==null){
            ((HttpServletResponse) servletResponse).sendRedirect("/filter/login.jsp");
        }else {
            //session没有失效放行
            filterChain.doFilter(servletRequest,servletResponse);
        }
        //符合条件放行
        System.out.println("我是第一个filter，我被执行了2");
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter.destroy()");
    }
}

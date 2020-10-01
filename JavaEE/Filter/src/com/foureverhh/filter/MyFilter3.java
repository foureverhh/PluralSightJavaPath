package com.foureverhh.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//@WebFilter("/ts.do")
public class MyFilter3 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我是第三个过滤器");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("我是第三个过滤器，我又被调用了");
    }

    @Override
    public void destroy() {

    }
}

package com.foureverhh.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("*.do")
public class MyFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("MyFilter2,我是第二个过滤器,我被执行了");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("MyFilter2,我是第二个过滤器,我又被执行了");
    }

    @Override
    public void destroy() {

    }
}

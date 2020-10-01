package com.foureverhh.springboot03filter.filter;


import javax.servlet.*;
import java.io.IOException;

public class SecondFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入second filter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("离开second filter");
    }
}

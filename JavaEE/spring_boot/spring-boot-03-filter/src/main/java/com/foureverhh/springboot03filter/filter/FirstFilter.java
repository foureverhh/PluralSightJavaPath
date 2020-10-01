package com.foureverhh.springboot03filter.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * Springboot 整合 filter
 * */
@WebFilter(filterName = "firstFilter", urlPatterns = {"/firstServlet", "*.do"})
public class FirstFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入first filter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("离开first filter");
    }
}

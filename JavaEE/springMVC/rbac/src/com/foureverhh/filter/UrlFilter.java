package com.foureverhh.filter;

import com.foureverhh.pojo.Url;
import com.foureverhh.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class UrlFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        String uri = req.getRequestURI();
        if(uri.endsWith(".js")||uri.endsWith(".css")||uri.endsWith(".html")||uri.endsWith(".jpg")||uri.endsWith("png")||uri.endsWith(".gif")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            if(uri.equals("/rbac/login")||uri.equals("/rbac/login.jsp")||uri.equals("/rbac/")){
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                HttpSession session = req.getSession();
                if(session.getAttribute("user") != null){
                    //说明用户已登录
                    List<Url> urlAll = (List<Url>)session.getAttribute("allUrl");
                    User user = (User) session.getAttribute("user");
                    List<Url> urls = user.getUrls();
                    System.out.println("Filter all urls: " + urlAll + ", user urls -> " + urls);
                    boolean urlExists = false;
                    for (Url url: urlAll) {
                            System.out.println("url.getName -> " + url.getName());
                            System.out.println("uri -> " + req.getRequestURI());

                        if (req.getRequestURI().equals("/"+url.getName())) {
                            //表示需要验证该user的url的权限
                            urlExists = true;
                            break;
                        }
                    }
                    if(urlExists){
                        //对用户的url权限进行验证
                        boolean hasRight =false;
                        for (Url u: urls) {
                            if(req.getRequestURI().equals("/"+u.getName())){
                                hasRight = true;
                                break;
                            }
                        }
                        if(hasRight){
                            //放行
                            filterChain.doFilter(servletRequest,servletResponse);
                        }else {
                            System.out.println("has right false");
                            session.removeAttribute("user");
                            session.removeAttribute("allUrl");
                            ((HttpServletResponse)servletResponse).sendRedirect("/rbac/index.jsp");
                        }
                    }else {
                        System.out.println("url exists false");
                        //url不存在项目的urls中，不允许继续
                        /*session.removeAttribute("user");
                        session.removeAttribute("allUrl");
                        ((HttpServletResponse)servletResponse).sendRedirect("/rbac/index.jsp");*/
                       //放行
                        filterChain.doFilter(servletRequest,servletResponse);
                    }
                }else{
                    //用户未登录，需回到登录界面
                    ((HttpServletResponse)servletResponse).sendRedirect("/rbac/index.jsp");
                }
            }
        }
    }

    @Override
    public void destroy() {

    }
}

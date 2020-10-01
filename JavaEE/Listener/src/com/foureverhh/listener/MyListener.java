package com.foureverhh.listener;

import javax.servlet.*;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*
* 监听器：
*      作用：
*          监听作用域对象request、session、application的创建、销毁和内容的改变
*      使用：
*          创建一个实现了指定接口的java类
*               监听request  --->   implements ServletRequestListener
*                                  requestInitialized
*                                  requestDestroyed
*
*               监听requestAttribute  --->   implements ServletRequestAttributeListener
*                                   attributeAdded
*                                   attributeRemoved
*                                   attributeReplaced
*               监听session --> implements HttpSessionListener
*                                   sessionCreated
*                                   sessionDestroyed
*
*
*               监听application --> implements ServletContextListener
*       web.xml中配置监听器类
*
*
*
* */
public class MyListener implements ServletRequestListener,
                                   ServletRequestAttributeListener,
                                   HttpSessionListener,
                                   HttpSessionAttributeListener,
                                    ServletContextListener,
                                    ServletContextAttributeListener{
    //Request对象销毁
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        ServletContext context = servletRequestEvent.getServletContext();
        System.out.println("listener 销毁了");
    }

    //Request对象创建
    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("listener 创建了");
    }

    //监听request作用域数据的添加
    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        String name = servletRequestAttributeEvent.getName();
        String value = (String) servletRequestAttributeEvent.getValue();
        System.out.println("request中增加一条数据, " + name + " : " + value);
    }

    //监听request作用域数据的
    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {

    }

    //
    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        /*
        String name = servletRequestAttributeEvent.getName();
        String value = (String) servletRequestAttributeEvent.getServletRequest().getAttribute(name);
        System.out.println("An attribute is replaced, " + name + " : " + value);
        */
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("session被创建了");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("session被销毁了");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session as \"" + httpSessionBindingEvent.getName() +
                ": "+httpSessionBindingEvent.getValue()+"\" created");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session as \"" + httpSessionBindingEvent.getName() +
                ": "+httpSessionBindingEvent.getValue()+"\" removed");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //servletContextEvent.getServletContext().setAttribute("");
        System.out.println("Application对象初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Application对象销毁");
    }

    //监听application的数据变更
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("Application中存储了数据： " +
                servletContextAttributeEvent.getName() +
                ":" +
                servletContextAttributeEvent.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {

    }
}

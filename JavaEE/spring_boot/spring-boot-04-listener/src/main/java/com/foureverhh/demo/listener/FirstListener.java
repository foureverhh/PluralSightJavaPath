package com.foureverhh.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class FirstListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Listener .... ini .....");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

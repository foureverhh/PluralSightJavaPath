package com.foureverhh.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SecondListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Second listener ... inits.....");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

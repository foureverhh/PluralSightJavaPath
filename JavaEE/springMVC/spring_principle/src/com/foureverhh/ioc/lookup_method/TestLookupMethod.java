package com.foureverhh.ioc.lookup_method;

import com.foureverhh.pojo.CommandManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLookupMethod {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:lookupmethod/applicationContext.xml");
        CommandManager manager = context.getBean("manager",CommandManager.class);
        System.out.println("manager 类型：-> "+manager.getClass().getSimpleName());
        manager.process();
    }
}

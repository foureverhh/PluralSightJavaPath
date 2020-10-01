package com.foureverhh.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:aop/applicationContext.xml");
        TestService service = context.getBean("service",TestService.class);
        System.out.println(service.getClass().getSimpleName());
        service.test("text execution");
    }
}

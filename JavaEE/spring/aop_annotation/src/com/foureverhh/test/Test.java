package com.foureverhh.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] names = ac.getBeanDefinitionNames();
        for (String name: names) {
            System.out.println(name);
        }
        Demo demo = ac.getBean("demo",Demo.class);
        try {
            demo.demo01();
        }catch (Exception e){

        }
    }
}

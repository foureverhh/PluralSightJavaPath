package com.bjsxt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        Demo demo = new ClassPathXmlApplicationContext("applicationContext.xml").getBean("demo",Demo.class);
        try {
            demo.demo2("张三",12);
            demo.demo2("李四");
        }catch (Exception e){

        }
    }
}

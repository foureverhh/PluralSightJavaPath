package com.bjsxt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Demo demo = ac.getBean("demo",Demo.class);
        try {
            demo.demo01();
        }catch (Exception e){
            //e.printStackTrace();
        }
  /*      demo.demo02();
        demo.demo03();
        demo.demo04("hello");
        demo.demo05("hi");
        System.out.println("------");
        Demo1 demo1 = ac.getBean("demo1",Demo1.class);
        demo1.demo11();*/
    }
}

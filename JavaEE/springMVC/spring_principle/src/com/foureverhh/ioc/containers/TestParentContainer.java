package com.foureverhh.ioc.containers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestParentContainer {
    public static void main(String[] args) {
        ApplicationContext parent = new ClassPathXmlApplicationContext("classpath:parent_container/applicationContext.xml");
        //ApplicationContext child = new ClassPathXmlApplicationContext("classpath:parent_container/applicationContext2.xml");
        //创建child容器对parent容器的继承
        ApplicationContext child = new ClassPathXmlApplicationContext(new String[]{"classpath:parent_container/applicationContext2.xml"},parent);
        System.out.println("context1.getBean(\"a\") - " + parent.getBean("a"));
        //System.out.println("context1.getBean(\"b\") - " + parent.getBean("b"));

        System.out.println("context2.getBean(\"a\") - " + child.getBean("a"));
        System.out.println("context2.getBean(\"b\") - " + child.getBean("b"));

        System.out.println("parent.getBean(\"oneBean\") - " + parent.getBean("oneBean"));
    }
}

package com.bjsxt.test;

public class Demo {
    public void demo01(){
        System.out.println("demo01");
        int i = 5/0;
    }
 /*   public void demo02(String name,int age){
        System.out.println("demo02: name-> "+name+", age->"+age);
    }*/

    public void demo02(){
        System.out.println("demo02");
    }
    public void demo03(){
        System.out.println("demo03");
    }

    public void demo04(String name){
        System.out.println("demo04: name-> "+name);
    }
    public String demo05(String name){
        System.out.println("demo05: name-> "+name);
        return name + "demo05";
    }
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.demo01();
        //demo.demo02("hello",12);
        demo.demo02();
        demo.demo03();
    }
}

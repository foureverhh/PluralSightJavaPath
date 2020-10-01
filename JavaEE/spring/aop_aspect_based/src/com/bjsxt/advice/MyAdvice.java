package com.bjsxt.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {
    public void myBefore(String name1,int age1){
        System.out.println("前置通知 "+name1 + ", " +age1);
    }
    public void myBefore1(String name1){
        System.out.println("前置通知 "+name1);
    }
    public void myAfter(){
        System.out.println("后置通知");
    }
    public void myAftering(){
        System.out.println("后置通知after returning");
    }

    public void myThrow(){
        System.out.println("Exception happen");
    }

    public Object myRound(ProceedingJoinPoint point) throws Throwable{
        System.out.println("环绕前置");
        Object result = point.proceed();
        System.out.println("环绕后置");
        return result;
    }
}

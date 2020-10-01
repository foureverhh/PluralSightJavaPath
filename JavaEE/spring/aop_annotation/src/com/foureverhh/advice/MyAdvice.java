package com.foureverhh.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
    @Before("com.foureverhh.test.Demo.demo01()")
    public void myBefore(){
        System.out.println("前置");
    }

    @After("com.foureverhh.test.Demo.demo01()")
    public void myAfter(){
        System.out.println("后置");
    }

    @AfterReturning("com.foureverhh.test.Demo.demo01()")
    public void myAfterReturning(){
        System.out.println("after returning");
    }

    @AfterThrowing(value = "com.foureverhh.test.Demo.demo01()",throwing = "e")
    public void afterThrowing(Exception e){
        System.out.println("after throwing" + e.getMessage());
    }

    @Around("com.foureverhh.test.Demo.demo01()")
    public Object Myaround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Around before");
        Object o = pjp.proceed();
        System.out.println("Around after");
        return o;
    }
}

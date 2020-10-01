package com.bjsxt.advice;

import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.aop.ThrowsAdvice;

import javax.servlet.ServletException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;

public class MyThrow implements ThrowsAdvice {
    public void afterThrowing(Exception ex) throws Throwable{
        System.out.println("EX-执行异常通知-schema_based");
    }

    public void afterThrowing(Method m, Object[] objects, Object target, Exception se){
        System.out.println("SE-执行异常通知-schema_based");
    }
}

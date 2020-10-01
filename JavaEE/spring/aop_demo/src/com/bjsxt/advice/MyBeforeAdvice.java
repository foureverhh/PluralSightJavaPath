package com.bjsxt.advice;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.jms.listener.endpoint.JmsMessageEndpointManager;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MyBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("切点方法对象："+method+", 切点方法名："+ method.getName());
        if(objects.length>0) {
            System.out.println("切点方法参数：" + Arrays.toString(objects));
        }else {
            System.out.println("切点无参数");
        }
        System.out.println("对象：" + o.getClass().getSimpleName());
        System.out.println("执行前置通知");
    }
}

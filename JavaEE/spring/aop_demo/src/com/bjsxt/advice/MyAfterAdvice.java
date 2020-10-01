package com.bjsxt.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MyAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("切点方法返回值对象：" + o);
        System.out.println("切点方法对象："+method+", method name:" + method.getName());
        System.out.println("切点方法参数：" + Arrays.toString(objects));
        System.out.println("切点方法所在对象：" + o1);
        System.out.println("after advice");
    }
}

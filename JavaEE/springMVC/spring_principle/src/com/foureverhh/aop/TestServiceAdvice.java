package com.foureverhh.aop;

import org.aopalliance.aop.Advice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestServiceAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        String info = "before advice run [ method name : " + method.getName()
                      + " , args: ( " + Arrays.toString(objects) + " )"
                      + " , target: " + o
                      + " , target class name: " + o.getClass().getSimpleName()
                      + " ]";
        System.out.println(info);
    }
}

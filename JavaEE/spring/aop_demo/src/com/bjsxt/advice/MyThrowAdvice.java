package com.bjsxt.advice;

import org.springframework.aop.ThrowsAdvice;

public class MyThrowAdvice  implements ThrowsAdvice {
    public void myException(Exception e){
        System.out.println("执行异常通知" + e.getMessage());
    }
}

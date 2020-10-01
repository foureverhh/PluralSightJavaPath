package com.foureverhh.aop;

public class TestServiceImpl implements TestService{
    @Override
    public void test(String str) {
        System.out.println("TestServiceImpl run: " + str);
    }
}

package com.foureverhh.pojo;

public class MyCommand1 extends CommandManager implements MyCommand{

    public MyCommand1() {
        System.out.println("MyCommand instantiated");
    }

    @Override
    protected MyCommand createCommand() {
        return new MyCommand1();
    }
}

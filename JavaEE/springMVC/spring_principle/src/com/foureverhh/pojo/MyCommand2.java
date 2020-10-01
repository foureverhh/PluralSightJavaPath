package com.foureverhh.pojo;

public class MyCommand2 extends CommandManager implements MyCommand{

    public MyCommand2() {
        System.out.println("MyCommand2 instantiated");
    }

    @Override
    protected MyCommand createCommand() {
        return new MyCommand2();
    }
}

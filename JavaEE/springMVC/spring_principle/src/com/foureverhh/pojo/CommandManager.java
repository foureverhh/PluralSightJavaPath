package com.foureverhh.pojo;

public abstract class CommandManager {

    public void process(){
        MyCommand command = createCommand();
        System.out.println("command 类型：-> " + command.getClass().getSimpleName());
    }

    protected abstract MyCommand createCommand();
}

package com.foureverhh.pojo;

public class OtherBean {
    private String name;

    public OtherBean() {
    }

    public OtherBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OtherBean{" +
                "name='" + name + '\'' +
                '}';
    }
}

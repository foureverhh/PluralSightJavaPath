package com.foureverhh.pojo;

public class OneBean {
    private int a;
    private Object o;

    public OneBean() {
    }

    public OneBean(int a, Object o) {
        this.a = a;
        this.o = o;
    }

    public OneBean(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }

    @Override
    public String toString() {
        return "OneBean{" +
                "a=" + a +
                ", o=" + o +
                '}';
    }
}

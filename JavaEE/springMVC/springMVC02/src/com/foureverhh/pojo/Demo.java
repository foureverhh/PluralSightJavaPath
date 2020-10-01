package com.foureverhh.pojo;

import java.util.List;

public class Demo {
    private List<People> peo;

    public List<People> getPeo() {
        return peo;
    }

    public void setPeo(List<People> peo) {
        this.peo = peo;
    }

    /*  private People peo;

    public People getPeo() {
        return peo;
    }

    public void setPeo(People peo) {
        this.peo = peo;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "peo=" + peo +
                '}';
    }*/

    @Override
    public String toString() {
        return "Demo{" +
                "peo=" + peo +
                '}';
    }
}

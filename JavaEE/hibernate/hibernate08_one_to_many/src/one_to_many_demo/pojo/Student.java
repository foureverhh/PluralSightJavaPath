package one_to_many_demo.pojo;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 4L;
    private int id;
    private String name;
    private int age;
    private String sex;
    //单向clz many_to_one 不需要clz的id
    //private Clz clz;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

 /*   public Clz getClz() {
        return clz;
    }

    public void setClz(Clz clz) {
        this.clz = clz;
    }*/

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex +
                '}';
    }
}

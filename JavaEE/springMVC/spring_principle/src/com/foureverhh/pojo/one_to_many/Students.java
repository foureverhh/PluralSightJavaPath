package com.foureverhh.pojo.one_to_many;

import java.io.Serializable;
import java.util.Objects;

public class Students implements Serializable {
    private static final long serialVersionUId = 2L;
    private int id;
    private String name;
    private int age;
    private Classes classes;
    private int clsId;

    public int getClsId() {
        return clsId;
    }

    public void setClsId(int clsId) {
        this.clsId = clsId;
    }

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

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Students)) return false;
        Students students = (Students) o;
        return getId() == students.getId() &&
                getAge() == students.getAge() &&
                Objects.equals(getName(), students.getName()) &&
                Objects.equals(getClasses(), students.getClasses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getClasses());
    }
}

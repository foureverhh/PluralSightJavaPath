package com.foureverhh.pojo.one_to_many;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Classes implements Serializable {
    private static final long serialVersionUId = 1L;
    private int id;
    private String name;
    private String teacherName;
    private List<Students> students;

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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", students=" + students +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Classes)) return false;
        Classes classes = (Classes) o;
        return getId() == classes.getId() &&
                Objects.equals(getName(), classes.getName()) &&
                Objects.equals(getTeacherName(), classes.getTeacherName()) &&
                Objects.equals(getStudents(), classes.getStudents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getTeacherName(), getStudents());
    }
}

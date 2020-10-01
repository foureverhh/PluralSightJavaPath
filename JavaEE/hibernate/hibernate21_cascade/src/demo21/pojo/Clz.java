package demo21.pojo;

import java.util.HashSet;
import java.util.Set;

public class Clz {
    private static final long serialVersionUID = 4L;
    private int id;
    private String name;
    private String address;
    private Set<Student> students = new HashSet<>();

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Clz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", students=" + students.toString()  +
                '}';
    }
}

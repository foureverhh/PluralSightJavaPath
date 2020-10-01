package pojo;

import java.util.List;

public class Teacher {
    //property name should meets column name to user auto-mapping
    //otherwise use alias in mapper.xml
    private String id;
    private String name;
    private List<Student> students;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id1='" + id + '\'' +
                ", name1='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}

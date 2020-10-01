package utils.model;

public class User {
    private int id,age;
    private String uname;

    public User() {


    }

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.uname = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return uname;
    }

    public void setName(String name) {
        this.uname = name;
    }
    public void setName() {
        this.uname = "haha";
    }

    private void showInfo(){
        System.out.println(id + ", " + uname + ", " +age);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", uname='" + uname + '\'' +
                '}';
    }
}

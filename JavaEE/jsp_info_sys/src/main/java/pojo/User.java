package pojo;

import java.util.Objects;

public class User {
    private int uid;
    private String uname;
    private String pwd;
    private String sex;
    private int age;
    private String birth;

    public User() {
    }

    public User( String uname, String pwd, String sex, int age, String birth) {
        this.uname = uname;
        this.pwd = pwd;
        this.sex = sex;
        this.age = age;
        this.birth = birth;
    }
    public User(int uid, String uname, String pwd, String sex, int age, String birth) {
        this(uname,pwd,sex,age,birth);
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUid() == user.getUid() &&
                getAge() == user.getAge() &&
                Objects.equals(getUname(), user.getUname()) &&
                Objects.equals(getPwd(), user.getPwd()) &&
                Objects.equals(getSex(), user.getSex()) &&
                Objects.equals(getBirth(), user.getBirth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid(), getUname(), getPwd(), getSex(), getAge(), getBirth());
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", birth='" + birth + '\'' +
                '}';
    }
}

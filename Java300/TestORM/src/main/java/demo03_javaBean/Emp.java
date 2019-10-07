package demo03_javaBean;

import java.sql.Date;

public class Emp {
   private Integer id;
   private String empname;
   private Integer age;
   private double salary;
   private Date birthday;
   private Integer depId;

    public Emp() {
    }

    public Emp(String empname, int age, double salary, Date birthday, Integer depId) {
        this.empname = empname;
        this.age = age;
        this.salary = salary;
        this.birthday = birthday;
        this.depId = depId;
    }

    public Emp(Integer id, String empname, int age, double salary, Date birthday, Integer depId) {
        this.id = id;
        this.empname = empname;
        this.age = age;
        this.salary = salary;
        this.birthday = birthday;
        this.depId = depId;
    }

    public Emp(String empname, double salary,int age) {
        this.empname = empname;
        this.age = age;
        this.salary = salary;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Integer getId() {
        return id;
    }

    public String getEmpname() {
        return empname;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Integer getDepId() {
        return depId;
    }
}

package com.foureverhh.pojo;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="t_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    //strategy = GenerationType.IDENTITY 表示id自增长
    private Integer id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_age")
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

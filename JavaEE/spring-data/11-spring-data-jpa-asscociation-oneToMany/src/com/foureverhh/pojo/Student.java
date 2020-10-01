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

    @OneToOne(cascade = CascadeType.PERSIST) //级联操作
    @JoinColumn(name = "role_id") //JoinColumn 作用就是维护外键
    private Role role;

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

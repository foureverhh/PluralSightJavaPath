package com.foureverhh.demo.pojo;

public class User {
    private Integer userId;
    private String username;
    private Integer userAge;

    public User() {
    }

    public User(Integer userId, String username, Integer userAge) {
        this.userId = userId;
        this.username = username;
        this.userAge = userAge;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
}

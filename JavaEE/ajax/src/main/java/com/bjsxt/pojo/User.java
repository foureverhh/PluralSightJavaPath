package com.bjsxt.pojo;

public class User {
    private int uid;
    private String name;
    private double price;
    private String loc;
    private String description;

    public User() {
    }

    public User(String name, double price, String loc, String desc) {
        this.name = name;
        this.price = price;
        this.loc = loc;
        this.description = desc;
    }

    public User(int uid, String name, double price, String loc, String desc) {
        this(name,price,loc,desc);
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", loc='" + loc + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

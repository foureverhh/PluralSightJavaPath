package com.foureverhh.pojo;

public class User {
    private int uid;
    private String name;
    private String fav;
    private Address addr;

    public User() {
    }

    public User(String name, String fav, Address addr) {
        this.name = name;
        this.fav = fav;
        this.addr = addr;
    }

    public User(int uid, String name, String fav, Address addr) {
        this(name,fav,addr);
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

    public String getFav() {
        return fav;
    }

    public void setFav(String fav) {
        this.fav = fav;
    }

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", fav='" + fav + '\'' +
                ", addr=" + addr +
                '}';
    }
}

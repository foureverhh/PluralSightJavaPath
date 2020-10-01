package ajaxData.model;

import java.util.Objects;

public class User {
    private int uid;
    private String uname;
    private double price;
    private String loc;
    private String desc;

    public User() {
    }

    public User(int uid, String uname, double price, String loc, String desc) {
        this.uid = uid;
        this.uname = uname;
        this.price = price;
        this.loc = loc;
        this.desc = desc;
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
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUid() == user.getUid() &&
                Double.compare(user.getPrice(), getPrice()) == 0 &&
                Objects.equals(getUname(), user.getUname()) &&
                Objects.equals(getLoc(), user.getLoc()) &&
                Objects.equals(getDesc(), user.getDesc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid(), getUname(), getPrice(), getLoc(), getDesc());
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", price=" + price +
                ", loc='" + loc + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

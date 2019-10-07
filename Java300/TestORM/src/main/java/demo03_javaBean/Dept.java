package demo03_javaBean;

public class Dept {
    private Integer id;
    private String dname;
    private String address;

    public Dept() {
    }

    public Dept(Integer id, String dname, String address) {
        this.id = id;
        this.dname = dname;
        this.address = address;
    }

    public Dept(String dname, String address) {
        this.dname = dname;
        this.address = address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getDname() {
        return dname;
    }

    public String getAddress() {
        return address;
    }
}

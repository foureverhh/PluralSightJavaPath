package demo12.pojo;

import java.io.Serializable;

public class Card implements Serializable {
    private static final long serialVersionUID = 5L;
    private String id;
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

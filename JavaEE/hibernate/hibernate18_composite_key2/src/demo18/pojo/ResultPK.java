package demo18.pojo;

import java.io.Serializable;

public class ResultPK implements Serializable {
    private static final long serialVersionUID = 6L;
    private int stuId;
    private int subId;

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }
}

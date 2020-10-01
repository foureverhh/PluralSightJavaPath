package demo17.pojo;

import java.io.Serializable;
/*组合主键的字段是类的属性时，该类必须实现*/
public class Result implements Serializable {
    private static final long serialVersionUID = 5L;
    private int stuId;
    private int subId;
    private double score;

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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}

package demo18.pojo;

import java.io.Serializable;

/*组合主键的字段是类的属性时，该类必须实现*/
public class Result implements Serializable {
    private static final long serialVersionUID = 5L;
    private ResultPK id;
    private double score;

    public ResultPK getId() {
        return id;
    }

    public void setId(ResultPK id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}

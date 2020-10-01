package demo19.pojo;

import java.io.Serializable;

/*组合主键的字段是类的属性时，该类必须实现*/
public class Result implements Serializable {
    private static final long serialVersionUID = 5L;
    private Student student;
    private Subject subject;
    private double score;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}

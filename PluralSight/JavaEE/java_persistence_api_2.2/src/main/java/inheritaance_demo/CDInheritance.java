package inheritaance_demo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CDInheritance extends ItemInheritance {
    @Column(name = "total_duration")
    private Float totalDuration;
    private String genre;

    public CDInheritance() {
    }

    public Float getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(Float totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "CDInheritance{" +
                "totalDuration=" + totalDuration +
                ", genre='" + genre + '\'' +
                '}';
    }
}

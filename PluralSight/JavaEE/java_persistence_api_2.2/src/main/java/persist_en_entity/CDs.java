package persist_en_entity;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CDs {

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id @GeneratedValue
    private Long id = null;

    private String title;

    private String description;

    private Float unitCost;

    private Float totalDuration;

    private String genre;
   // @OneToMany(cascade = CascadeType.PERSIST)
   // @JoinColumn(name = "cd_fk")
   // private Set<Musician> musicians = new HashSet<>();
    // ======================================
    // =            Constructors            =
    // ======================================

    public CDs() {
    }

    public CDs(String title) {
        this.title = title;
    }
    public CDs(String title, String description, Float unitCost, Float totalDuration, String genre) {
        this.title = title;
        this.description = description;
        this.unitCost = unitCost;
        this.totalDuration = totalDuration;
        this.genre = genre;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================


    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    @Column(length = 100)
    public String getTitle() {return title;}

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(length = 3000)
    public String getDescription() {return description;}

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "unit_cost")
    public Float getUnitCost() {return unitCost;}

    public void setUnitCost(Float unitCost) {
        this.unitCost = unitCost;
    }

    @Column(name = "total_duration")
    public Float getTotalDuration() {return totalDuration;}

    public void setTotalDuration(Float totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getGenre() {return genre;}

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // ======================================
    // =    hashcode, equals & toString     =
    // ======================================

/*

    @Override
    public String toString() {
        return "CD{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", unitCost=" + unitCost +
                ", totalDuration=" + totalDuration +
                ", genre='" + genre + '\'' +
                ", musicians=" + musicians +
                '}';
    }

    public Set<Musician> getMusicians() {
        return musicians;
    }

    public void setMusicians(Set<Musician> musicians) {
        this.musicians = musicians;
    }

*/


}



/*
public class CD {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private Float unitCost;
    private Float totalDurable;
    private String genre;

    @OneToMany
    @JoinColumn
    private Set<Musician> musicians = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Float unitCost) {
        this.unitCost = unitCost;
    }

    public Float getTotalDurable() {
        return totalDurable;
    }

    public void setTotalDurable(Float totalDurable) {
        this.totalDurable = totalDurable;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "CD{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", unitCost=" + unitCost +
                ", totalDurable=" + totalDurable +
                ", genre='" + genre + '\'' +
                '}';
    }
}
*/

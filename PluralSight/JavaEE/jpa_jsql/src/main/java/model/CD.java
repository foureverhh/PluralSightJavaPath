package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CD extends Item{

    private String genre;
    @Column(name = "MUSIC_COMPANY")
    private String musicCompany;
    @Column(name = "TOTAL_DURATION")
    private Float totalDuration;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CD_MUSICIAN", joinColumns = @JoinColumn(name = "CD_FK"),inverseJoinColumns = @JoinColumn(name = "MUSICIAN_FK") )
    private Set<Musician> musicians = new HashSet<Musician>();
    public CD() {
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getMusicCompany() {
        return musicCompany;
    }

    public void setMusicCompany(String musicCompany) {
        this.musicCompany = musicCompany;
    }

    public Float getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(Float totalDuration) {
        this.totalDuration = totalDuration;
    }

    public Set<Musician> getMusicians() {
        return musicians;
    }

    public void setMusicians(Set<Musician> musicians) {
        this.musicians = musicians;
    }
}

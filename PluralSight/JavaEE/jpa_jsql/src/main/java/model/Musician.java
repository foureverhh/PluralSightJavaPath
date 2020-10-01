package model;

import listener.AgeCalculationListener;
import listener.ValidationListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners({

        ValidationListener.class
})
//@ExcludeDefaultListeners
public class Musician extends Artist{

    @Column(name = "PREFERRED_INSTRUMENT")
    private String preferredInstrument;
    @Column(name = "BIO")
    private String bio;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "MUSICIAN_CD" , joinColumns = @JoinColumn(name = "MUSICIAN_FK"),inverseJoinColumns = @JoinColumn(name = "CD_FK"))
    private Set<CD> cds = new HashSet<CD>();

    public Musician() {
    }

    public Musician(String firstName,String lastName,LocalDate dateOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getPreferredInstrument() {
        return preferredInstrument;
    }

    public void setPreferredInstrument(String preferredInstrument) {
        this.preferredInstrument = preferredInstrument;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Set<CD> getCds() {
        return cds;
    }

    public void setCds(Set<CD> cds) {
        this.cds = cds;
    }

    @Override
    public String toString() {
        return "Musician{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", preferredInstrument='" + preferredInstrument + '\'' +
                ", bio='" + bio + '\'' +
                ", cds=" + cds +
                ", age=" + age +
                '}';
    }
}

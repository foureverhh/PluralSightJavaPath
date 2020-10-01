package model;

import listener.ValidationListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Entity
//@EntityListeners(ValidationListener.class)
public class Author extends Artist{

    @Column (name = "PREFERRED_LANGUAGE")
    private String language;

    @Column(name = "BIO")
    private String bio;

    public Author() {
    }

    public Author(String firstName,String lastName,LocalDate dateOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

/*

    @PrePersist
    @PreUpdate
    private void validate() {
        if( firstName == null || "".equals(firstName)){
            throw new IllegalArgumentException("Invalid first name");
        }
        if( lastName == null || "".equals(lastName)){
            throw  new IllegalArgumentException("Invalid last name");
        }
    }

    @PostLoad
    @PostPersist
    @PostUpdate
    private void calculateAge(){
        age = Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
*/

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", language='" + language + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", bio='" + bio + '\'' +
                ", age=" + age +
                '}';
    }
}

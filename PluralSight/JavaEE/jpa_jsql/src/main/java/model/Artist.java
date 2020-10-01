package model;

import listener.AgeCalculationListener;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
@EntityListeners(AgeCalculationListener.class)
public class Artist {
    @Id
    @GeneratedValue
    protected Long id;
    @Column(name = "first_name",length = 50)
    protected String firstName;
    @Column(name = "last_name", length = 50)
    protected String lastName;
    @Column(name = "date_of_birth")
    protected LocalDate dateOfBirth;
    @Transient
    protected Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

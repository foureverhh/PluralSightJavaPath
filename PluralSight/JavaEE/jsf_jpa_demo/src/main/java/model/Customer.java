package model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Customer extends User{
    @Column(name = "premium")
    private Boolean isPremium;

    public Boolean getPremium() {
        return isPremium;
    }

    public void setPremium(Boolean premium) {
        isPremium = premium;
    }
}

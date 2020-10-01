package listener;

import model.Artist;
import model.Author;
import model.Musician;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculationListener {
/*    @PostLoad
    @PostPersist
    @PostUpdate
    public void calculateAuthorAge(Author author){
        author.setAge(Period.between(author.getDateOfBirth(), LocalDate.now()).getYears());
    }*/

    @PostLoad
    @PostPersist
    @PostUpdate
    public void calculateMusicianAge(Artist artist){
        System.out.println(".AgeCalculationListener calculateAge()");
        if(artist.getDateOfBirth() == null){
            artist.setAge(null);
            return;
        }
        artist.setAge(Period.between(artist.getDateOfBirth(), LocalDate.now()).getYears());
    }
}

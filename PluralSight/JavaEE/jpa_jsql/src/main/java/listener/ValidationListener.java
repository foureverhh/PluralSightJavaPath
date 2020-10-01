package listener;

import com.sun.xml.internal.xsom.XSUnionSimpleType;
import model.Artist;
import model.Author;
import model.Musician;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class ValidationListener {
    @PrePersist
    @PreUpdate
    private void validate(Artist o){
        System.out.println(".ValidationListener validate()");
        if( o.getFirstName() == null || "".equals(o.getFirstName())){
            throw  new IllegalArgumentException("Invalid first name");
        }
        if(o.getLastName() == null || "".equals(o.getLastName())){
            throw new IllegalArgumentException("Invalid last name");
        }
    }
}

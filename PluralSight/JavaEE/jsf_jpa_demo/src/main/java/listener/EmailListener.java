package listener;

import model.User;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class EmailListener {
    @PrePersist
    @PreUpdate
    public void nameValidator(User user){
        if(!user.getEmail().contains("@")){
            throw new IllegalArgumentException("Illegal email without @");
        }
    }
}

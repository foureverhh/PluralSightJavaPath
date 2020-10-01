package persist_en_entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Items {
    @Id
    @GeneratedValue
    private Long id;
}

package inheritaance_demo;

import javax.persistence.EntityManager;

public class ItemInheritanceService {
    private EntityManager entityManager;

    public CDInheritance crateCD(EntityManager entityManager, CDInheritance cdInheritance){
        CDInheritance temp = entityManager.merge(cdInheritance);
        entityManager.persist(temp);
        return temp;
    }

    public BookInheritance createBook(EntityManager entityManager, BookInheritance bookInheritance){
        BookInheritance temp = entityManager.merge(bookInheritance);
        entityManager.persist(temp);
        return temp;
    }
}

package inheritaance_demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("inheritance");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction action = manager.getTransaction();

        ItemInheritanceService service = new ItemInheritanceService();

        CDInheritance cdInheritance = new CDInheritance();
        cdInheritance.setTitle("Sergent Pepper");
        cdInheritance.setGenre("Pop/Rock");
        action.begin();
        cdInheritance = service.crateCD(manager, cdInheritance);
        action.commit();
        System.out.println("CD Persisted: " + cdInheritance);

        BookInheritance bookInheritance = new BookInheritance();
        bookInheritance.setTitle("H2G2");
        bookInheritance.setIsbn("1234-4567-789");
        action.begin();
        bookInheritance = service.createBook(manager, bookInheritance);
        action.commit();
        System.out.println("Book Persisted: " + bookInheritance);
    }

}

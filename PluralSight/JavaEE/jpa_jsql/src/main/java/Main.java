import com.sun.tools.internal.ws.wsdl.framework.EntityAction;
import model.Author;
import model.Musician;
import model.Publisher;
import service.QueryService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {

    private static QueryService service;

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJSQl");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

       /* Publisher publisher = new Publisher();
        publisher.setId(11);
        publisher.setName("test");
        action.begin();
        manager.persist(publisher);
        action.commit();
        System.out.println("Publisher saved: " + publisher);*/
        service = new QueryService(manager);
        /*
        service.queryBooks();
        service.queryBooksTyped();
        */
    /*   //Trigger validate() in Author
        System.out.println("Create an invalid author ");
        transaction.begin();
        service.createAuthor(new Author(null,null,null));
        transaction.commit();*/
    /*    System.out.println("Create a valid author");
        transaction.begin();
        Long id = service.createAuthor(new Author("John","Smith", LocalDate.of(1975,1,1)));
        transaction.commit();

        System.out.println("--Find artist");
        System.out.println(service.findAuthor(id));
*/
     /*   System.out.println("Create an invalid musician ");
        transaction.begin();
        service.createMusician(new Musician(null,null,null));
        transaction.commit();*/

        System.out.println("Create a valid musician");
        transaction.begin();
        long id = service.createMusician(new Musician("John","Smith", LocalDate.of(1975,1,1)));
        transaction.commit();

        System.out.println("--Find musician");
        System.out.println(service.findMusician(id));

        manager.close();
        factory.close();
    }
}

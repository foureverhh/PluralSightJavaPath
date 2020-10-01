package persist_en_entity;


import persist_en_entity.service.CDService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
    public static EntityManager em = emf.createEntityManager();
    public static EntityTransaction tx = em.getTransaction();


    public static void main(String[] args){

        System.out.println("\n\n>>> Executing : " + Main.class.toString() + " <<<\n");

        CDService service = new CDService(em);

        // Creates and persists a CD
        tx.begin();
        CDs CDs = service.createCD(new CDs("Selling England by the Pound", "5th studio album by the progressive rock band Genesis", 12.5F, 53.39F, "Progressive Rock"));

        tx.commit();

        System.out.println("CD Persisted : " + CDs);

        // Finds the cd by primary key
        CDs = service.findCD(CDs.getId());

        System.out.println("CD Found     : " + CDs);

        // Deletes the cd
        tx.begin();
        service.removeCD(CDs.getId());
        tx.commit();

        System.out.println("CD Removed");

        // Finds the cd  by primary key
        CDs = service.findCD(CDs.getId());

//        System.out.println("CD Not Found : " + cd);
//        tx.begin();
//        Set<Musician> beatles = new HashSet<>();
//        beatles.add(new Musician("John","Lennon"));
//        beatles.add(new Musician("Paul","McCartney"));
//        beatles.add(new Musician("Ringo","Starr"));
//        beatles.add(new Musician("Georges","Harrison"));
//        CD sergentPepper = new CD("Sergent Pepper");
//        sergentPepper.setMusicians(beatles);
//        sergentPepper = service.createCD(sergentPepper);
//        tx.commit();
//        System.out.println("CD persisted " + sergentPepper);


        //cd = sergentPepper;

        // Add beatles to CD record
        //persistCDWithMusicians(cd);
        /*tx.begin();
        service.removeCD(cd);
        System.out.println(cd.getTitle() + "is Deleted");
        tx.commit();*/

        em.close();
        emf.close();
    }

    public static void persistCDWithMusicians(CDs CDs){
        em.persist(CDs);
        System.out.println("Sergent Pepper persisted");
    }
}
/*


public class Main {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();
    private static EntityTransaction entityTransaction = entityManager.getTransaction();
    public static void main(String[] args) {

        */
/*
        BookService bookService = new BookService();
        Book book = bookService.createBook(40444L, "H2G2", "Scifi Book", 12.5f, "1234", 100);
        System.out.println("Book Persisted: " + book);

        book = bookService.findBook(4044L);
        System.out.println("Book found:" + book);

        book = bookService.raiseUnitCost(4044L,12.f);
        System.out.println("Book updated: " + book);
        *//*


        */
/*
        AuthorService authorService = new AuthorService();
        Author author = authorService.createAuthor("Douglas",
                "Adams",
                "Douglas's bio",
                LocalDate.of(1986,3,12),
                Language.DTD);
        System.out.println("Author persisted: " + author);
        *//*




        */
/*Set<Musician> beatles = new HashSet<>();
        beatles.add(new Musician())*//*

    }

    public static void handleCD(){
        CDService cdService = new CDService(entityManager);
        CD cd = cdService.createCD(1100L,"Beauty CD","Beauty description", 100f,20f,"Folk Music");
        System.out.println("CD created: " + cd);
        //cd = cdService.updateCD(cd,100f);
        //System.out.println("CD updated: " + cd);
        cdService.removeCD(1100L);
        System.out.println(cd + " is removed");
        cdService.closeAll();


    }
}
*/

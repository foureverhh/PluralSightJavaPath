package jpa_appearance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("module01PU");
    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        persistBook(new BookWithJPA(500L,"H2G2","Best Scifi Book",12.5f,"1234-5678-5678",280));
        findBook(500L);
    }

    private static void persistBook(BookWithJPA bookWithJPA) {
        em.persist(bookWithJPA);
    }

    private static BookWithJPA findBook(Long id){
       return em.find(BookWithJPA.class,id);
    }

    static {
        try{
            Class.forName("org.h2.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:~cdbookstoreDB");
    }
}

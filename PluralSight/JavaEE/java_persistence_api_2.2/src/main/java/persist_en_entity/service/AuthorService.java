package persist_en_entity.service;

import com.sun.tools.internal.xjc.Language;
import persist_en_entity.Author;
import sun.util.resources.LocaleData;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class AuthorService {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction entityTransaction = entityManager.getTransaction();


    public Author createAuthor (String first, String last, String bio, LocalDate date, Language language){
        Author author = new Author();
        //author.setId(id);
        author.setFirstName(first);
        author.setLastName(last);
        author.setBio(bio);
        author.setDateOfBirth(date);
        author.setLanguage(language);
        entityManager.persist(author);
        return author;
    }

    public  Author findAuthor(Long id){
        return entityManager.find(Author.class,id);
    }

    //remove a book object
    public  void removeAuthor(Long id){
        Author author = entityManager.find(Author.class, id);
        if(author != null){
            entityTransaction.begin();
            entityManager.remove(author);
            entityTransaction.commit();
        }
    }

    //remove a author alternative
    public  void removeAuthor(Author author){
        //make this author object managed by the entity manager
        Author authorToBeDeleted = entityManager.merge(author);

        entityTransaction.begin();
        entityManager.remove(authorToBeDeleted);
        entityTransaction.commit();
    }

  /*  //update
    public Author raiseUnitCost(Long id, Float raise){
        Author author = entityManager.find(Author.class,id);
        if(author != null) {
            float price = author.getCost();
            author.setCost(price + raise);

            entityTransaction.begin();
            entityManager.persist(author);
            entityTransaction.commit();
        }
        return author;
    }

    //update alternative
    public Author raiseUnitCost(Author author,Float raise){
        Author authorToBeUpdated = entityManager.merge(author);
        authorToBeUpdated.setCost(authorToBeUpdated.getCost() + raise);
        entityTransaction.begin();
        entityManager.persist(authorToBeUpdated);
        entityTransaction.commit();
        return authorToBeUpdated;
    }*/
}

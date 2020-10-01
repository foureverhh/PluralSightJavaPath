package persist_en_entity.service;


import persist_en_entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

//persist an entity
public class BookService {
    private  EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
    private  EntityManager entityManager = entityManagerFactory.createEntityManager();
    private  EntityTransaction entityTransaction = entityManager.getTransaction();


    public Book createBook (Long id, String title, String desc, Float cost, String isbn, Integer pages){
        Book book = new Book(id,title,desc,cost,isbn,pages);
        book.setId(id);
        book.setTitle(title);
        book.setDesc(desc);
        book.setCost(cost);
        entityManager.persist(book);
        return book;
    }

    public  Book findBook(Long id){
        return entityManager.find(Book.class,id);
    }

    //remove a book object
    public  void removeBook(Long id){
        Book book = entityManager.find(Book.class, id);
        if(book != null){
            entityTransaction.begin();
            entityManager.remove(book);
            entityTransaction.commit();
        }
    }

    //remove a book alternative
    public  void removeBook(Book book){
        //make this book object managed by the entity manager
        Book bookToBeDeleted = entityManager.merge(book);

        entityTransaction.begin();
        entityManager.remove(bookToBeDeleted);
        entityTransaction.commit();
    }

    //update
    public Book raiseUnitCost(Long id, Float raise){
        Book book = entityManager.find(Book.class,id);
        if(book != null) {
            float price = book.getCost();
            book.setCost(price + raise);

            entityTransaction.begin();
            entityManager.persist(book);
            entityTransaction.commit();
        }
        return book;
    }

    //update alternative
    public Book raiseUnitCost(Book book,Float raise){
        Book bookToBeUpdated = entityManager.merge(book);
        bookToBeUpdated.setCost(bookToBeUpdated.getCost() + raise);
        entityTransaction.begin();
        entityManager.persist(bookToBeUpdated);
        entityTransaction.commit();
        return bookToBeUpdated;
    }

}

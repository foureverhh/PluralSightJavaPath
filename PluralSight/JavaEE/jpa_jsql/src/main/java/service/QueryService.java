package service;

import model.Author;
import model.Book;
import model.Musician;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class QueryService {
    private EntityManager em;

    public QueryService(EntityManager em) {
        this.em = em;
    }

    public void queryBooks() {
        Query query = em.createQuery("SELECT b FROM Book b where b.unitCost > 29 AND  b.pages < 700");
        List books = query.getResultList();
        System.out.println("Query books");
        for (int i = 0; i < books.size() ; i++) {
            Book book = (Book) books.get(i);
            System.out.println(book);
        }
    }

    public void queryBooksTyped() {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b where b.unitCost > 29 AND  b.pages < 700",Book.class);
        List<Book> books = query.getResultList();
        System.out.println("Query typed books");
        books.forEach(System.out::print);
    }

    public long createAuthor(Author author){
        em.persist(author);
        return author.getId();
    }

    public Author findAuthor(Long id) {
        return em.find(Author.class,id);
    }

    public long createMusician(Musician musician){
        em.persist(musician);
        return musician.getId();
    }

    public Musician findMusician(Long id) {
        return em.find(Musician.class,id);
    }
}

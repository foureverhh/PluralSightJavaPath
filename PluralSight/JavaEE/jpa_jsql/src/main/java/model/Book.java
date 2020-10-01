package model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQuery(name = "ExpensiveBooks", query = "select b from Book b where b.unitCost > 29 and b.pages < 700")
public class Book extends Item{
    private String isbn;
    @Column(name = "NB_OF_PAGES")
    private Integer pages;
    private String language;
    @Column(name = "PUBLICATION_DATE")
    private Date publicationDate;
    @OneToMany (cascade = CascadeType.PERSIST)
    @JoinTable(name = "BOOK_AUTHOR", joinColumns = @JoinColumn(name = "Book_FK"),inverseJoinColumns = @JoinColumn(name = "AUTHOR_FK") )
    private Set<Author> authors = new HashSet<>();
    @JoinColumn(name = "PUBLISHER_PK")
    @OneToOne (cascade = CascadeType.PERSIST)
    private Publisher publisher;

    public Book() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", pages=" + pages +
                ", language='" + language + '\'' +
                ", publicationDate=" + publicationDate +
                ", authors=" + authors +
                ", publisher=" + publisher +
                '}';
    }
}


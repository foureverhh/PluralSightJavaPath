package inheritaance_demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class BookInheritance extends ItemInheritance {
    @Column(length = 15)
    private String isbn;
    @Column(name = "nb_of_pages")
    private Integer nbOfPages;
    @Column(name = "publication_date")
    private LocalDate publicationDate;

    public BookInheritance() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNbOfPages() {
        return nbOfPages;
    }

    public void setNbOfPages(Integer nbOfPages) {
        this.nbOfPages = nbOfPages;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return "BookInheritance{" +
                "isbn='" + isbn + '\'' +
                ", nbOfPages=" + nbOfPages +
                ", publicationDate=" + publicationDate +
                '}';
    }
}

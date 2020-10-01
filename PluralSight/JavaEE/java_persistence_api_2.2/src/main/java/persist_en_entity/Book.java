package persist_en_entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    private Long id;
    private String title;
    private String desc;
    private Float cost;
    private String isbn;
    private Integer pages;

    public Book() {
    }

    public Book(Long id, String title, String desc, Float cost, String isbn, Integer pages){
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.cost = cost;
        this.isbn = isbn;
        this.pages = pages;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", cost=" + cost +
                ", isbn='" + isbn + '\'' +
                ", pages=" + pages +
                '}';
    }
}

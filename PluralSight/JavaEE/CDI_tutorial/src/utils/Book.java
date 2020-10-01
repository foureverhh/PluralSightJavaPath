package utils;

public class Book {
    private String title;
    private String label;

    public Book() {
    }

    public Book(String title, String label) {
        this.title = title;
        this.label = label;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}

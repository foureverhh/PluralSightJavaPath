package interface_dependency;

import utils.Book;

public class BookService {
    LabelGenerator generator ;

    public BookService() {
    }

    public BookService(LabelGenerator generator) {
        this.generator = generator;
    }

    public Book createBook(String title){
        return new Book(title,generator.generateLabel());
    }
}

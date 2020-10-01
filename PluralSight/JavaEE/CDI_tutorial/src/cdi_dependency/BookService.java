package cdi_dependency;

import utils.Book;

import javax.inject.Inject;

public class BookService {
    @Inject @ISBN
    LabelGenerator generator ;

    public Book createBook(String title){
        return new Book(title,generator.generateLabel());
    }
}

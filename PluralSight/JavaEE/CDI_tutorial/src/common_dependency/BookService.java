package common_dependency;

import utils.Book;

public class BookService {
    IsbnGenerator isbn = new IsbnGenerator();
    public Book createBook(String title){
        return new Book(title, isbn.generateNumber());
    }
}

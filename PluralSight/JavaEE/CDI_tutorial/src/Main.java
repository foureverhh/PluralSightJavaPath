import cdi_dependency.BookService;
import cdi_dependency.ISBN;
import utils.Book;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\n>>> Executing : " + Main.class.toString() + " <<<\n");

   /*     // this will give you a CdiContainer for Weld or OWB, depending on the jar you added
        CdiContainer cdiContainer = CdiContainerLoader.getCdiContainer();

        // now we gonna boot the CDI container. This will trigger the classpath scan, etc
        cdiContainer.boot();

        BeanManager beanManager = cdiContainer.getBeanManager();

        Set<Bean<?>> beans = beanManager.getBeans(BookService.class);
        Bean<?> bean = beanManager.resolve(beans);

        BookService bookService = (BookService) beanManager.getReference(bean, BookService.class, beanManager.createCreationalContext(bean));


        System.out.println("# " + bookService.createBook("H2G2"));
        System.out.println("# " + bookService.createBook("Lord of the Ring"));

        // finally we gonna stop the container
        cdiContainer.shutdown();*/
        
      /*  @Inject
        BookService bookService ;
        Book  book = bookService.createBook("cdi_book");
        System.out.println(book);*/
    }
}

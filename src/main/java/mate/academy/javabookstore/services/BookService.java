package mate.academy.javabookstore.services;

import java.util.List;
import mate.academy.javabookstore.models.Book;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}

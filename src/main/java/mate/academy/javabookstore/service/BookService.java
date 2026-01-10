package mate.academy.javabookstore.service;

import java.util.List;
import mate.academy.javabookstore.model.Book;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}

package mate.academy.javabookstore.repository;

import java.util.List;
import mate.academy.javabookstore.model.Book;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();
}

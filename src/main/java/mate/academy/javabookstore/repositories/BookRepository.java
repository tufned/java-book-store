package mate.academy.javabookstore.repositories;

import java.util.List;
import mate.academy.javabookstore.models.Book;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();
}

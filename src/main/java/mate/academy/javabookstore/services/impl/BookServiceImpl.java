package mate.academy.javabookstore.services.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.javabookstore.models.Book;
import mate.academy.javabookstore.repositories.BookRepository;
import mate.academy.javabookstore.services.BookService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}

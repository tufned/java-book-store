package mate.academy.javabookstore.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.javabookstore.model.Book;
import mate.academy.javabookstore.repository.BookRepository;
import mate.academy.javabookstore.service.BookService;
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

package mate.academy.javabookstore.services.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.javabookstore.dto.BookDto;
import mate.academy.javabookstore.dto.CreateBookRequestDto;
import mate.academy.javabookstore.exceptions.EntityNotFoundException;
import mate.academy.javabookstore.mappers.BookMapper;
import mate.academy.javabookstore.models.Book;
import mate.academy.javabookstore.repositories.BookRepository;
import mate.academy.javabookstore.services.BookService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto book) {
        Book bookModel = bookMapper.toModel(book);
        Book savedBook = bookRepository.save(bookModel);
        return bookMapper.toDto(savedBook);
    }

    @Override
    public List<BookDto> findAll() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(bookMapper::toDto).toList();
    }

    @Override
    public BookDto findBookById(Long id) {
        Book book = bookRepository.findBookById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can't find book with id: " + id));
        return bookMapper.toDto(book);
    }
}

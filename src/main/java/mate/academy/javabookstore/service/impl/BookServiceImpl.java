package mate.academy.javabookstore.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.javabookstore.dto.BookDto;
import mate.academy.javabookstore.dto.CreateBookRequestDto;
import mate.academy.javabookstore.exception.EntityNotFoundException;
import mate.academy.javabookstore.mapper.BookMapper;
import mate.academy.javabookstore.model.Book;
import mate.academy.javabookstore.repository.BookRepository;
import mate.academy.javabookstore.service.BookService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto book) {
        Book bookModel = bookMapper.toModel(book);
        bookRepository.save(bookModel);
        return bookMapper.toDto(bookModel);
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto findBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can't find book with id: " + id));
        return bookMapper.toDto(book);
    }
}

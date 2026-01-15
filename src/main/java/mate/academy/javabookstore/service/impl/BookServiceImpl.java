package mate.academy.javabookstore.service.impl;

import lombok.RequiredArgsConstructor;
import mate.academy.javabookstore.dto.book.BookDto;
import mate.academy.javabookstore.dto.book.BookSearchParametersDto;
import mate.academy.javabookstore.dto.book.CreateBookRequestDto;
import mate.academy.javabookstore.exception.EntityNotFoundException;
import mate.academy.javabookstore.mapper.BookMapper;
import mate.academy.javabookstore.model.Book;
import mate.academy.javabookstore.repository.book.BookRepository;
import mate.academy.javabookstore.repository.book.BookSpecificationBuilder;
import mate.academy.javabookstore.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookSpecificationBuilder bookSpecificationBuilder;

    @Override
    public BookDto save(CreateBookRequestDto book) {
        Book bookModel = bookMapper.toModel(book);
        bookRepository.save(bookModel);
        return bookMapper.toDto(bookModel);
    }

    @Override
    public Page<BookDto> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable).map(bookMapper::toDto);
    }

    @Override
    public BookDto findById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can't find book with id: " + id));
        return bookMapper.toDto(book);
    }

    @Override
    public BookDto update(Long id, CreateBookRequestDto createBookRequestDto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can't find book by id: " + id));

        bookMapper.updateModelFromDto(createBookRequestDto, book);

        bookRepository.save(book);
        return bookMapper.toDto(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Page<BookDto> searchBooks(BookSearchParametersDto searchParameters, Pageable pageable) {
        return bookRepository.findAll(bookSpecificationBuilder.build(searchParameters), pageable)
                .map(bookMapper::toDto);
    }
}

package mate.academy.javabookstore.service;

import java.util.List;
import mate.academy.javabookstore.dto.book.BookDto;
import mate.academy.javabookstore.dto.book.BookSearchParametersDto;
import mate.academy.javabookstore.dto.book.CreateBookRequestDto;

public interface BookService {
    BookDto save(CreateBookRequestDto book);

    List<BookDto> findAll();

    BookDto findById(Long id);

    BookDto update(Long id, CreateBookRequestDto book);

    void delete(Long id);

    List<BookDto> searchBooks(BookSearchParametersDto searchParameters);
}

package mate.academy.javabookstore.service;

import mate.academy.javabookstore.dto.book.BookDto;
import mate.academy.javabookstore.dto.book.BookSearchParametersDto;
import mate.academy.javabookstore.dto.book.BookWithoutCategoryIds;
import mate.academy.javabookstore.dto.book.CreateBookRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookDto save(CreateBookRequestDto book);

    Page<BookDto> findAll(Pageable pageable);

    BookDto findById(Long id);

    BookDto update(Long id, CreateBookRequestDto book);

    void deleteById(Long id);

    Page<BookDto> searchBooks(BookSearchParametersDto searchParameters, Pageable pageable);

    Page<BookWithoutCategoryIds> getCategoryBooks(Long categoryId, Pageable pageable);
}

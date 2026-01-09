package mate.academy.javabookstore.services;

import java.util.List;
import mate.academy.javabookstore.dto.BookDto;
import mate.academy.javabookstore.dto.CreateBookRequestDto;

public interface BookService {
    BookDto save(CreateBookRequestDto book);

    List<BookDto> findAll();

    BookDto findBookById(Long id);
}

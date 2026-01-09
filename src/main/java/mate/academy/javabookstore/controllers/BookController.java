package mate.academy.javabookstore.controllers;

import java.util.List;
import mate.academy.javabookstore.dto.BookDto;
import mate.academy.javabookstore.dto.CreateBookRequestDto;

public interface BookController {
    public List<BookDto> getAll();

    public BookDto getBookById(Long id);

    public BookDto createBook(CreateBookRequestDto bookDto);
}

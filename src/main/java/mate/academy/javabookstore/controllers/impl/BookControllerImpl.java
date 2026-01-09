package mate.academy.javabookstore.controllers.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.javabookstore.controllers.BookController;
import mate.academy.javabookstore.dto.BookDto;
import mate.academy.javabookstore.dto.CreateBookRequestDto;
import mate.academy.javabookstore.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookControllerImpl implements BookController {
    private final BookService bookService;

    @Override
    @GetMapping
    public List<BookDto> getAll() {
        return bookService.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.findBookById(id);
    }

    @Override
    @PostMapping
    public BookDto createBook(@RequestBody CreateBookRequestDto bookDto) {
        return bookService.save(bookDto);
    }
}

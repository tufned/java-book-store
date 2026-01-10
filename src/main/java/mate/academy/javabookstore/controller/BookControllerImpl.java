package mate.academy.javabookstore.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.javabookstore.dto.BookDto;
import mate.academy.javabookstore.dto.CreateBookRequestDto;
import mate.academy.javabookstore.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookControllerImpl {
    private final BookService bookService;

    @GetMapping
    public List<BookDto> getAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.findBookById(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public BookDto createBook(@RequestBody CreateBookRequestDto bookDto) {
        return bookService.save(bookDto);
    }
}

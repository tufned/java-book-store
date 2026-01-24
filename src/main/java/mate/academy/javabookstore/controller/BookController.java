package mate.academy.javabookstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mate.academy.javabookstore.dto.book.BookDto;
import mate.academy.javabookstore.dto.book.BookSearchParametersDto;
import mate.academy.javabookstore.dto.book.CreateBookRequestDto;
import mate.academy.javabookstore.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
@Tag(name = "Book", description = "Book entity endpoints")
public class BookController {
    private final BookService bookService;

    @GetMapping
    @Operation(summary = "Get all books",
               description = "Returns all books. Default sorting: ASC by id.")
    public Page<BookDto> getAll(@PageableDefault(sort = "id") Pageable pageable) {
        return bookService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get book by id",
               description = "Returns a single book based on the provided id")
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @Operation(summary = "Create book", description = """
            Creates a new book based on the provided request\s
            body and returns it with generated id. Only for admins.""")
    @PreAuthorize("hasRole('ADMIN')")
    public BookDto createBook(@RequestBody @Valid CreateBookRequestDto bookDto) {
        return bookService.save(bookDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update book", description = """
            Updates a book based on the provided request body and returns it. Only for admins.""")
    @PreAuthorize("hasRole('ADMIN')")
    public BookDto updateBook(@PathVariable Long id,
                              @RequestBody @Valid CreateBookRequestDto bookDto) {
        return bookService.update(id, bookDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete book by id",
               description = "Deletes the book based on the provided id. Only for admins.")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @GetMapping("/search")
    @Operation(summary = "Search book by params", description = """
            Returns all books based on the provided search params: title or author.
            Default sorting: ASC by id.""")
    public Page<BookDto> searchBooks(@Valid BookSearchParametersDto searchParameters,
                                     @PageableDefault(sort = "id") Pageable pageable) {
        return bookService.searchBooks(searchParameters, pageable);
    }
}

package mate.academy.javabookstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mate.academy.javabookstore.dto.book.BookWithoutCategoryIds;
import mate.academy.javabookstore.dto.category.CategoryDto;
import mate.academy.javabookstore.dto.category.CreateCategoryRequestDto;
import mate.academy.javabookstore.service.BookService;
import mate.academy.javabookstore.service.CategoryService;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController("/categories")
@RequiredArgsConstructor
@Tag(name = "Category", description = "Category entity endpoints")
public class CategoryController {
    private final CategoryService categoryService;
    private final BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create category", description = """
            Creates a new category based on the provided request
            body and returns it with generated id. Only for admins.""")
    @PreAuthorize("hasRole('ADMIN')")
    public CategoryDto create(@RequestBody @Valid CreateCategoryRequestDto dto) {
        return categoryService.save(dto);
    }

    @GetMapping
    @Operation(summary = "Get all categories",
               description = "Returns all categories. Default sorting: ASC by id.")
    public Page<CategoryDto> getAll(@PageableDefault(sort = "id") Pageable pageable) {
        return categoryService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get category by id",
               description = "Returns a single category based on the provided id")
    public CategoryDto getById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update category", description = """
            Updates a category based on the provided request body and returns it.
            Only for admins.""")
    @PreAuthorize("hasRole('ADMIN')")
    public CategoryDto update(@PathVariable Long id,
                              @RequestBody @Valid CreateCategoryRequestDto dto) {
        return categoryService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete category by id",
               description = "Deletes the category based on the provided id. Only for admins.")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id) {
        categoryService.deleteById(id);
    }

    @GetMapping("/{id}/books")
    @Operation(summary = "Get book by category",
               description = "Returns all books of sertan category. Default sorting: ASC by id.")
    public Page<BookWithoutCategoryIds> getCategoryBooks(@PathVariable Long id,
                                                         @PageableDefault(sort = "id")
                                                         Pageable pageable) {
        return bookService.getCategoryBooks(id, pageable);
    }
}

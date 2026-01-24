package mate.academy.javabookstore.mapper;

import java.util.List;
import mate.academy.javabookstore.config.MapperConfig;
import mate.academy.javabookstore.dto.book.BookDto;
import mate.academy.javabookstore.dto.book.BookWithoutCategoryIds;
import mate.academy.javabookstore.dto.book.CreateBookRequestDto;
import mate.academy.javabookstore.model.Book;
import mate.academy.javabookstore.model.Category;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    @AfterMapping
    default void setCategoryIds(@MappingTarget BookDto bookDto, Book book) {
        if (book.getCategories() == null) {
            return;
        }
        List<Long> ids = book
                .getCategories()
                .stream()
                .map(Category::getId)
                .toList();
        bookDto.setCategoryIds(ids);
    }

    Book toModel(CreateBookRequestDto bookDto);

    void updateModelFromDto(CreateBookRequestDto bookDto, @MappingTarget Book book);

    BookWithoutCategoryIds toDtoWithoutCategories(Book model);
}

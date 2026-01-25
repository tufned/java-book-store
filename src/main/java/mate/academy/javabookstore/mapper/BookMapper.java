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
import org.mapstruct.Mapping;
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

    @Mapping(source = "categoryIds", target = "categories")
    Book toModel(CreateBookRequestDto bookDto);

    @Mapping(source = "categoryIds", target = "categories")
    void updateModelFromDto(CreateBookRequestDto bookDto, @MappingTarget Book book);

    default Category toCategoryFromId(Long id) {
        Category category = new Category();
        category.setId(id);
        return category;
    }

    BookWithoutCategoryIds toDtoWithoutCategories(Book model);
}

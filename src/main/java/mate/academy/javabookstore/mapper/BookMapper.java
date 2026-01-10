package mate.academy.javabookstore.mapper;

import mate.academy.javabookstore.config.MapperConfig;
import mate.academy.javabookstore.dto.BookDto;
import mate.academy.javabookstore.dto.CreateBookRequestDto;
import mate.academy.javabookstore.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(CreateBookRequestDto bookDto);
}

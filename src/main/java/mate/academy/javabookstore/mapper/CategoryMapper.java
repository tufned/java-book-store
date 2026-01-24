package mate.academy.javabookstore.mapper;

import mate.academy.javabookstore.config.MapperConfig;
import mate.academy.javabookstore.dto.category.CategoryDto;
import mate.academy.javabookstore.dto.category.CreateCategoryRequestDto;
import mate.academy.javabookstore.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface CategoryMapper {
    CategoryDto toDto(Category model);

    Category toModel(CreateCategoryRequestDto dto);

    void updateModelFromDto(CreateCategoryRequestDto dto, @MappingTarget Category model);
}

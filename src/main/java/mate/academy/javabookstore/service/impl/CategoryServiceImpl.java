package mate.academy.javabookstore.service.impl;

import lombok.RequiredArgsConstructor;
import mate.academy.javabookstore.dto.category.CategoryDto;
import mate.academy.javabookstore.dto.category.CreateCategoryRequestDto;
import mate.academy.javabookstore.exception.EntityNotFoundException;
import mate.academy.javabookstore.mapper.CategoryMapper;
import mate.academy.javabookstore.model.Category;
import mate.academy.javabookstore.repository.category.CategoryRepository;
import mate.academy.javabookstore.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public Page<CategoryDto> findAll(Pageable pageable) {
        return categoryRepository
                .findAll(pageable)
                .map(categoryMapper::toDto);
    }

    @Override
    public CategoryDto findById(Long id) {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Can't find category with id: " + id));
        return categoryMapper.toDto(category);
    }

    @Override
    public CategoryDto save(CreateCategoryRequestDto categoryDto) {
        Category category = categoryMapper.toModel(categoryDto);
        categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }

    @Override
    public CategoryDto update(Long id, CreateCategoryRequestDto categoryDto) {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Can't find category with id: " + id));
        categoryMapper.updateModelFromDto(categoryDto, category);
        categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}

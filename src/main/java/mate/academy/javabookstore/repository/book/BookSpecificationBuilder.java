package mate.academy.javabookstore.repository.book;

import lombok.RequiredArgsConstructor;
import mate.academy.javabookstore.dto.book.BookSearchParametersDto;
import mate.academy.javabookstore.model.Book;
import mate.academy.javabookstore.repository.SpecificationBuilder;
import mate.academy.javabookstore.repository.SpecificationProviderManager;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {
    private final SpecificationProviderManager<Book> specificationProviderManager;

    @Override
    public Specification<Book> build(BookSearchParametersDto searchParamsDto) {
        Specification<Book> specification = Specification.where(
                (root, query, criteriaBuilder) -> criteriaBuilder.conjunction());

        if (searchParamsDto.title() != null && !searchParamsDto.title().isEmpty()) {
            specification = specification.and(specificationProviderManager.getSpecificationProvider(
                            BookSpecificationFields.TITLE.getKey())
                    .getSpecification(searchParamsDto.title()));
        }

        if (searchParamsDto.author() != null && !searchParamsDto.author().isEmpty()) {
            specification = specification.and(specificationProviderManager.getSpecificationProvider(
                            BookSpecificationFields.AUTHOR.getKey())
                    .getSpecification(searchParamsDto.author()));
        }

        return specification;
    }
}

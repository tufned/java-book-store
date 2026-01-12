package mate.academy.javabookstore.repository;

import org.springframework.data.jpa.domain.Specification;

public abstract class LikeSpecificationProvider<T> implements SpecificationProvider<T> {
    private final String fieldName;

    protected LikeSpecificationProvider(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String getKey() {
        return fieldName;
    }

    @Override
    public Specification<T> getSpecification(String param) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get(fieldName)),
                        "%" + param.toLowerCase() + "%");
    }
}

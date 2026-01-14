package mate.academy.javabookstore.repository.book;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum BookSpecificationFields {
    TITLE("title"), AUTHOR("author");

    private final String key;
}

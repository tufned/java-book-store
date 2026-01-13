package mate.academy.javabookstore.dto.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import mate.academy.javabookstore.constants.BookConstants;

public record CreateBookRequestDto(
        @NotBlank
        @Size(min = BookConstants.MIN_TITLE_SIZE, max = BookConstants.MAX_TITLE_SIZE)
        String title,
        @NotBlank
        @Size(min = BookConstants.MIN_AUTHOR_SIZE, max = BookConstants.MAX_AUTHOR_SIZE)
        String author,
        @NotBlank
        @Pattern(regexp = BookConstants.ISBN_REGEX, message = BookConstants.ISBN_REGEX_ERROR_MSG)
        String isbn,
        @NotNull
        @Positive
        BigDecimal price,
        String description,
        String coverImage
) {
}

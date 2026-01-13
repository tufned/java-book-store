package mate.academy.javabookstore.dto.book;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import mate.academy.javabookstore.constants.BookConstants;

public record CreateBookRequestDto(
        @NotNull
        @Size(min = BookConstants.MIN_TITLE_SIZE, max = BookConstants.MAX_TITLE_SIZE)
        String title,
        @NotNull
        @Size(min = BookConstants.MIN_AUTHOR_SIZE, max = BookConstants.MAX_AUTHOR_SIZE)
        String author,
        @NotNull
        @Pattern(regexp = BookConstants.ISBN_REGEX, message = BookConstants.ISBN_REGEX_ERROR_MSG)
        String isbn,
        @NotNull
        @Min(0)
        BigDecimal price,
        String description,
        String coverImage
) {
}

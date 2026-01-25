package mate.academy.javabookstore.dto.book;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;
import mate.academy.javabookstore.constants.book.BookConstants;
import mate.academy.javabookstore.constants.book.BookDocs;

public record CreateBookRequestDto(
        @NotBlank
        @Size(min = BookConstants.MIN_TITLE_SIZE, max = BookConstants.MAX_TITLE_SIZE)
        @Schema(description = BookDocs.TITLE_DESC, example = BookDocs.TITLE_EX)
        String title,

        @NotBlank
        @Size(min = BookConstants.MIN_AUTHOR_SIZE, max = BookConstants.MAX_AUTHOR_SIZE)
        @Schema(description = BookDocs.AUTHOR_DESC, example = BookDocs.AUTHOR_EX)
        String author,

        @NotBlank
        @Pattern(regexp = BookConstants.ISBN_REGEX, message = BookConstants.ISBN_REGEX_ERROR_MSG)
        @Schema(description = BookDocs.ISBN_DESC, example = BookDocs.ISBN_EX)
        String isbn,

        @NotNull
        @Positive
        @Schema(description = BookDocs.PRICE_DESC, example = BookDocs.PRICE_EX)
        BigDecimal price,

        @Schema(description = BookDocs.DESCRIPTION_DESC, example = BookDocs.DESCRIPTION_EX)
        String description,

        @Schema(description = BookDocs.COVER_IMAGE_DESC, example = BookDocs.COVER_IMAGE_EX)
        String coverImage,

        @Schema(example = BookDocs.CATEGORY_IDS_EX)
        List<Long> categoryIds
) {
}

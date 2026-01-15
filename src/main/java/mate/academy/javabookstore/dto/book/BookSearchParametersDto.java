package mate.academy.javabookstore.dto.book;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import mate.academy.javabookstore.constants.AppConstants;
import mate.academy.javabookstore.constants.book.BookDocs;

public record BookSearchParametersDto(
        @Size(min = AppConstants.MIN_SEARCH_PARAM_SIZE)
        @Schema(description = BookDocs.TITLE_DESC, example = BookDocs.TITLE_EX)
        String title,
        @Size(min = AppConstants.MIN_SEARCH_PARAM_SIZE)
        @Schema(description = BookDocs.AUTHOR_DESC, example = BookDocs.AUTHOR_EX)
        String author
) {
}

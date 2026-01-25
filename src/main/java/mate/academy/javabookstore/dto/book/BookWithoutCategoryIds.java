package mate.academy.javabookstore.dto.book;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import mate.academy.javabookstore.constants.book.BookDocs;

public record BookWithoutCategoryIds(
        @Schema(description = BookDocs.ID_DESC, example = BookDocs.ID_EX)
        Long id,

        @Schema(description = BookDocs.TITLE_DESC, example = BookDocs.TITLE_EX)
        String title,

        @Schema(description = BookDocs.AUTHOR_DESC, example = BookDocs.AUTHOR_EX)
        String author,

        @Schema(description = BookDocs.ISBN_DESC, example = BookDocs.ISBN_EX)
        String isbn,

        @Schema(description = BookDocs.PRICE_DESC, example = BookDocs.PRICE_EX)
        BigDecimal price,

        @Schema(description = BookDocs.DESCRIPTION_DESC, example = BookDocs.DESCRIPTION_EX)
        String description,

        @Schema(description = BookDocs.COVER_IMAGE_DESC, example = BookDocs.COVER_IMAGE_EX)
        String coverImage
) {
}

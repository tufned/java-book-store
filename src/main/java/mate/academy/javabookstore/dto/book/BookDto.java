package mate.academy.javabookstore.dto.book;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import mate.academy.javabookstore.constants.book.BookDocs;

@Getter
@Setter
public class BookDto {
    @Schema(description = BookDocs.ID_DESC, example = BookDocs.ID_EX)
    private Long id;

    @Schema(description = BookDocs.TITLE_DESC, example = BookDocs.TITLE_EX)
    private String title;

    @Schema(description = BookDocs.AUTHOR_DESC, example = BookDocs.AUTHOR_EX)
    private String author;

    @Schema(description = BookDocs.ISBN_DESC, example = BookDocs.ISBN_EX)
    private String isbn;

    @Schema(description = BookDocs.PRICE_DESC, example = BookDocs.PRICE_EX)
    private BigDecimal price;

    @Schema(description = BookDocs.DESCRIPTION_DESC, example = BookDocs.DESCRIPTION_EX)
    private String description;

    @Schema(description = BookDocs.COVER_IMAGE_DESC, example = BookDocs.COVER_IMAGE_EX)
    private String coverImage;

    @Schema(example = BookDocs.CATEGORY_IDS_EX)
    private List<Long> categoryIds;
}

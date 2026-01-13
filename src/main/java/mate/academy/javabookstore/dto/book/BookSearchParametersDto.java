package mate.academy.javabookstore.dto.book;

import jakarta.validation.constraints.Size;
import mate.academy.javabookstore.constants.AppConstants;

public record BookSearchParametersDto(
        @Size(min = AppConstants.MIN_SEARCH_PARAM_SIZE)
        String title,
        @Size(min = AppConstants.MIN_SEARCH_PARAM_SIZE)
        String author
) {
}

package mate.academy.javabookstore.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import mate.academy.javabookstore.constants.user.UserDocs;

public record UserDto(
        Long id,
        String email,
        @Schema(description = UserDocs.NAME_DESC, example = UserDocs.FIRST_NAME_EX)
        String firstName,
        @Schema(description = UserDocs.NAME_DESC, example = UserDocs.LAST_NAME_EX)
        String lastName,
        @Schema(description = UserDocs.SHIPPING_ADDRESS_DESC,
                example = UserDocs.SHIPPING_ADDRESS_EX)
        String shippingAddress
) {
}

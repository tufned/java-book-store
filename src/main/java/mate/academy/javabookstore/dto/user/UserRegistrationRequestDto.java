package mate.academy.javabookstore.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import mate.academy.javabookstore.constants.user.UserConstants;
import mate.academy.javabookstore.constants.user.UserDocs;
import mate.academy.javabookstore.validate.FieldMatch;

@FieldMatch(first = "password", second = "repeatPassword", message = "Passwords don't match")
public record UserRegistrationRequestDto(
        @NotBlank
        @Email
        String email,

        @Pattern(regexp = UserConstants.PASSWORD_REGEX)
        @Schema(description = UserDocs.PASSWORD_DESC, example = UserDocs.PASSWORD_EX)
        String password,

        @Pattern(regexp = UserConstants.PASSWORD_REGEX)
        @Schema(description = UserDocs.REPEAT_PASSWORD_DESC, example = UserDocs.PASSWORD_EX)
        String repeatPassword,

        @Size(min = UserConstants.MIN_NAME_SIZE, max = UserConstants.MAX_NAME_SIZE)
        @Schema(description = UserDocs.NAME_DESC, example = UserDocs.FIRST_NAME_EX)
        String firstName,

        @Size(min = UserConstants.MIN_NAME_SIZE, max = UserConstants.MAX_NAME_SIZE)
        @Schema(description = UserDocs.NAME_DESC, example = UserDocs.LAST_NAME_EX)
        String lastName,

        @Schema(description = UserDocs.SHIPPING_ADDRESS_DESC,
                example = UserDocs.SHIPPING_ADDRESS_EX)
        String shippingAddress
) {
}

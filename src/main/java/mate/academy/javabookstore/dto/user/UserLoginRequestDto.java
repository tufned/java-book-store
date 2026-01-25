package mate.academy.javabookstore.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import mate.academy.javabookstore.constants.user.UserConstants;
import mate.academy.javabookstore.constants.user.UserDocs;

public record UserLoginRequestDto(
        @NotBlank
        @Email
        String email,

        @Pattern(regexp = UserConstants.PASSWORD_REGEX)
        @Schema(description = UserDocs.PASSWORD_DESC, example = UserDocs.PASSWORD_EX)
        String password
) {
}

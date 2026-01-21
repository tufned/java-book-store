package mate.academy.javabookstore.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import mate.academy.javabookstore.constants.user.UserConstants;
import mate.academy.javabookstore.validate.FieldMatch;

@FieldMatch(first = "password", second = "repeatPassword", message = "Passwords don't match")
public record UserRegistrationRequestDto(
        @NotBlank
        @Email
        String email,

        @Pattern(regexp = UserConstants.PASSWORD_REGEX)
        String password,

        @Pattern(regexp = UserConstants.PASSWORD_REGEX)
        String repeatPassword,

        @Size(min = UserConstants.MIN_NAME_SIZE, max = UserConstants.MAX_NAME_SIZE)
        String firstName,

        @Size(min = UserConstants.MIN_NAME_SIZE, max = UserConstants.MAX_NAME_SIZE)
        String lastName,

        String shippingAddress
) {
}

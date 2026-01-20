package mate.academy.javabookstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mate.academy.javabookstore.dto.user.UserDto;
import mate.academy.javabookstore.dto.user.UserRegistrationRequestDto;
import mate.academy.javabookstore.exception.RegistrationException;
import mate.academy.javabookstore.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "Authentication endpoints")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/registration")
    @Operation(summary = "Register a user",
               description = "Creates a user based on request body and returns UserDto")
    public UserDto register(@RequestBody @Valid UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        return authenticationService.register(requestDto);
    }
}

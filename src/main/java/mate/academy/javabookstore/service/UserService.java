package mate.academy.javabookstore.service;

import mate.academy.javabookstore.dto.user.UserDto;
import mate.academy.javabookstore.dto.user.UserRegistrationRequestDto;
import mate.academy.javabookstore.exception.RegistrationException;

public interface UserService {
    UserDto register(UserRegistrationRequestDto requestDto) throws RegistrationException;
}

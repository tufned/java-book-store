package mate.academy.javabookstore.service;

import mate.academy.javabookstore.dto.auth.TokenResponseDto;
import mate.academy.javabookstore.dto.user.UserLoginRequestDto;

public interface AuthService {
    TokenResponseDto authenticate(UserLoginRequestDto requestDto);
}

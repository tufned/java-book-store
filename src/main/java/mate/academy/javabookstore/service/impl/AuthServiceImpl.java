package mate.academy.javabookstore.service.impl;

import lombok.RequiredArgsConstructor;
import mate.academy.javabookstore.dto.auth.TokenResponseDto;
import mate.academy.javabookstore.dto.user.UserLoginRequestDto;
import mate.academy.javabookstore.exception.AuthenticationException;
import mate.academy.javabookstore.mapper.AuthMapper;
import mate.academy.javabookstore.model.User;
import mate.academy.javabookstore.repository.user.UserRepository;
import mate.academy.javabookstore.security.JwtUtil;
import mate.academy.javabookstore.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private static final String AUTH_ERROR_MSG = "Incorrect email or password";
    private final UserRepository userRepository;
    private final AuthMapper authMapper;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Override
    public TokenResponseDto authenticate(UserLoginRequestDto requestDto) {
        User user = userRepository
                .findByEmail(requestDto.email())
                .orElseThrow(() -> new AuthenticationException(AUTH_ERROR_MSG));
        if (!passwordEncoder.matches(requestDto.password(), user.getPassword())) {
            throw new AuthenticationException(AUTH_ERROR_MSG);
        }
        return authMapper.toTokenDto(jwtUtil.generateToken(requestDto.email()));
    }
}

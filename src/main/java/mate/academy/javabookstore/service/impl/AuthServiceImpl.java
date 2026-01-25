package mate.academy.javabookstore.service.impl;

import lombok.RequiredArgsConstructor;
import mate.academy.javabookstore.dto.auth.TokenResponseDto;
import mate.academy.javabookstore.dto.user.UserLoginRequestDto;
import mate.academy.javabookstore.security.JwtUtil;
import mate.academy.javabookstore.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager manager;

    @Override
    public TokenResponseDto authenticate(UserLoginRequestDto requestDto) {
        final Authentication authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(requestDto.email(), requestDto.password()));
        String token = jwtUtil.generateToken(authentication.getName());
        return new TokenResponseDto(token);
    }
}

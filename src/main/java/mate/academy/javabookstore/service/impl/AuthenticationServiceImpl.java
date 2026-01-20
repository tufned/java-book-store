package mate.academy.javabookstore.service.impl;

import lombok.RequiredArgsConstructor;
import mate.academy.javabookstore.dto.user.UserDto;
import mate.academy.javabookstore.dto.user.UserRegistrationRequestDto;
import mate.academy.javabookstore.exception.RegistrationException;
import mate.academy.javabookstore.mapper.UserMapper;
import mate.academy.javabookstore.model.User;
import mate.academy.javabookstore.repository.user.UserRepository;
import mate.academy.javabookstore.service.AuthenticationService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public UserDto register(UserRegistrationRequestDto requestDto) throws RegistrationException {
        if (userRepository.existsByEmail(requestDto.email())) {
            throw new RegistrationException("Can't register user");
        }
        User user = userMapper.toModel(requestDto);
        userRepository.save(user);
        return userMapper.toDto(user);
    }
}

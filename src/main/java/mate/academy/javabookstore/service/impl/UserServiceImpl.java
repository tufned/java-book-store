package mate.academy.javabookstore.service.impl;

import java.util.Set;
import lombok.RequiredArgsConstructor;
import mate.academy.javabookstore.dto.user.UserDto;
import mate.academy.javabookstore.dto.user.UserRegistrationRequestDto;
import mate.academy.javabookstore.exception.EntityNotFoundException;
import mate.academy.javabookstore.exception.RegistrationException;
import mate.academy.javabookstore.mapper.UserMapper;
import mate.academy.javabookstore.model.Role;
import mate.academy.javabookstore.model.User;
import mate.academy.javabookstore.repository.role.RoleRepository;
import mate.academy.javabookstore.repository.user.UserRepository;
import mate.academy.javabookstore.service.UserService;
import mate.academy.javabookstore.utils.PasswordEncoderUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoderUtil passwordEncoderUtil;

    @Override
    @Transactional
    public UserDto register(UserRegistrationRequestDto requestDto) throws RegistrationException {
        if (userRepository.existsByEmail(requestDto.email())) {
            throw new RegistrationException("User already registered: " + requestDto);
        }
        User user = userMapper.toModel(requestDto);
        Role role = roleRepository
                .findByName(Role.RoleName.USER)
                .orElseThrow(() -> new EntityNotFoundException("Can't find user role"));
        passwordEncoderUtil.encodePassword(user);
        user.setRoles(Set.of(role));
        userRepository.save(user);
        return userMapper.toDto(user);
    }
}

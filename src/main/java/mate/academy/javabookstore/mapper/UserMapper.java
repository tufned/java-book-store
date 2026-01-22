package mate.academy.javabookstore.mapper;

import mate.academy.javabookstore.config.MapperConfig;
import mate.academy.javabookstore.dto.user.UserDto;
import mate.academy.javabookstore.dto.user.UserRegistrationRequestDto;
import mate.academy.javabookstore.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    User toModel(UserRegistrationRequestDto dto);

    UserDto toDto(User model);
}

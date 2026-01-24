package mate.academy.javabookstore.mapper;

import mate.academy.javabookstore.config.MapperConfig;
import mate.academy.javabookstore.dto.auth.TokenResponseDto;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface AuthMapper {
    TokenResponseDto toTokenDto(String token);
}

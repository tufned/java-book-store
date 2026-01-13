package mate.academy.javabookstore.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponseDto(
        LocalDateTime timestamp,
        List<String> messages,
        int statusCode
) {
}

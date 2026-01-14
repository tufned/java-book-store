package mate.academy.javabookstore.utils;

import java.time.LocalDateTime;
import java.util.List;
import mate.academy.javabookstore.dto.response.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseEntityProvider {
    public ResponseEntity<ErrorResponseDto> getResponseEntity(List<String> messages,
                                                              HttpStatus statusCode) {
        return new ResponseEntity<>(
                new ErrorResponseDto(LocalDateTime.now(), messages, statusCode.value()),
                statusCode);
    }

    public ResponseEntity<ErrorResponseDto> getResponseEntity(String message,
                                                              HttpStatus statusCode) {
        return new ResponseEntity<>(
                new ErrorResponseDto(LocalDateTime.now(), List.of(message), statusCode.value()),
                statusCode);
    }
}

package mate.academy.javabookstore.exception;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import mate.academy.javabookstore.constants.AppConstants;
import mate.academy.javabookstore.dto.response.ErrorResponseDto;
import mate.academy.javabookstore.utils.ResponseEntityProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice
@RequiredArgsConstructor
public class CustomGlobalExceptionHandler {
    private final ResponseEntityProvider responseEntityProvider;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponseDto> handleAllExceptions(Exception e) {
        log.error("Error: ", e);
        return responseEntityProvider.getResponseEntity(AppConstants.DEFAULT_ERROR_MSG,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataProcessingException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponseDto> handleDataProcessingException(
            DataProcessingException e) {
        return responseEntityProvider.getResponseEntity(e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponseDto> handleEntityNotFoundException(
            EntityNotFoundException e) {
        return responseEntityProvider.getResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<ErrorResponseDto> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        List<String> errors =
                e.getBindingResult().getAllErrors().stream().map(this::getErrorMessage).toList();
        return responseEntityProvider.getResponseEntity(errors, HttpStatus.NOT_ACCEPTABLE);
    }

    private String getErrorMessage(ObjectError err) {
        if (err instanceof FieldError fieldError) {
            return fieldError.getField() + ": " + err.getDefaultMessage();
        }
        return err.getDefaultMessage();
    }

    @ExceptionHandler(RegistrationException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<ErrorResponseDto> handleRegistrationException(
            RegistrationException e) {
        return responseEntityProvider.getResponseEntity(e.getMessage(), HttpStatus.FORBIDDEN);
    }
}

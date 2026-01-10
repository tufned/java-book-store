package mate.academy.javabookstore.exception;

public class DataProcessingException extends RuntimeException {
    public DataProcessingException(String message) {
        super(message);
    }

    public DataProcessingException(String message, Throwable e) {
        super(message, e);
    }
}

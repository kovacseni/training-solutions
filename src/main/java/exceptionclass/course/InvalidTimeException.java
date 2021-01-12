package exceptionclass.course;

public class InvalidTimeException extends RuntimeException {

    private String message;

    public InvalidTimeException() {
    }

    public InvalidTimeException(String message) {
        super(message);
    }
}

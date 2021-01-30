package exam02.photo;

public class PhotoNotFoundException extends RuntimeException {

    public PhotoNotFoundException() {
        super();
    }

    public PhotoNotFoundException(String message) {
        super(message);
    }

    public PhotoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

package datenewtypes;

public class MissedOpportunityException extends RuntimeException {

    public MissedOpportunityException() {
        super();
    }

    public MissedOpportunityException(String message) {
        super(message);
    }

    public MissedOpportunityException(String message,Throwable cause) {
        super(message, cause);
    }
}

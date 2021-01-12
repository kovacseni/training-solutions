package exceptionclass.bank;

public class InvalidBankOperationException extends RuntimeException {

    private ErrorCode errorCode;

    public InvalidBankOperationException(ErrorCode errorCode) {
        super(String.valueOf(errorCode));
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}

package exceptionclass.bank2;

import exceptionclass.bank.ErrorCode;

public class InvalidAmountBankOperationException extends InvalidBankOperationException {

    private ErrorCode errorCode;

    public InvalidAmountBankOperationException() {
        super();
        this.errorCode = ErrorCode.INVALID_AMOUNT;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}

package exceptionclass.bank2;

import exceptionclass.bank.ErrorCode;

public class InvalidAccountNumberBankOperationException extends InvalidBankOperationException {

    private ErrorCode errorCode;

    public InvalidAccountNumberBankOperationException() {
        super();
        this.errorCode = ErrorCode.INVALID_ACCOUNTNUMBER;
    }

    public ErrorCode getErrorCode() {
            return errorCode;
        }
}

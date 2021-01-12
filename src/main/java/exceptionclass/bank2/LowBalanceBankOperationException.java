package exceptionclass.bank2;

import exceptionclass.bank.ErrorCode;

public class LowBalanceBankOperationException extends InvalidBankOperationException {

    private ErrorCode errorCode;

    public LowBalanceBankOperationException() {
        super();
        this.errorCode = ErrorCode.LOW_BALANCE;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}

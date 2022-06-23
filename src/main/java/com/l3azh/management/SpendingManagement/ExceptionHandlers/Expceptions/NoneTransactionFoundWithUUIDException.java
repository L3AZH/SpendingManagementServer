package com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions;

public class NoneTransactionFoundWithUUIDException extends Exception{
    public NoneTransactionFoundWithUUIDException() {
        super();
    }

    public NoneTransactionFoundWithUUIDException(String message) {
        super(message);
    }

    public NoneTransactionFoundWithUUIDException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoneTransactionFoundWithUUIDException(Throwable cause) {
        super(cause);
    }

    protected NoneTransactionFoundWithUUIDException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions;

public class NoneTransactionFoundWithUUIDWalletException extends Exception{
    public NoneTransactionFoundWithUUIDWalletException() {
        super();
    }

    public NoneTransactionFoundWithUUIDWalletException(String message) {
        super(message);
    }

    public NoneTransactionFoundWithUUIDWalletException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoneTransactionFoundWithUUIDWalletException(Throwable cause) {
        super(cause);
    }

    protected NoneTransactionFoundWithUUIDWalletException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

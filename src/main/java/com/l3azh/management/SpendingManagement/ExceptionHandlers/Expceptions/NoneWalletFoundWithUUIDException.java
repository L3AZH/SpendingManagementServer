package com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions;

public class NoneWalletFoundWithUUIDException extends Exception{
    public NoneWalletFoundWithUUIDException() {
        super();
    }

    public NoneWalletFoundWithUUIDException(String message) {
        super(message);
    }

    public NoneWalletFoundWithUUIDException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoneWalletFoundWithUUIDException(Throwable cause) {
        super(cause);
    }

    protected NoneWalletFoundWithUUIDException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

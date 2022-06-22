package com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions;

public class NoneWalletFoundWithEmailException extends Exception {
    public NoneWalletFoundWithEmailException() {
        super();
    }

    public NoneWalletFoundWithEmailException(String message) {
        super(message);
    }

    public NoneWalletFoundWithEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoneWalletFoundWithEmailException(Throwable cause) {
        super(cause);
    }

    protected NoneWalletFoundWithEmailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

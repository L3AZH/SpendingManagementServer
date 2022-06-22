package com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions;

public class WalletWithNameAlreadyExistInDb extends Exception{

    public WalletWithNameAlreadyExistInDb() {
        super();
    }

    public WalletWithNameAlreadyExistInDb(String message) {
        super(message);
    }

    public WalletWithNameAlreadyExistInDb(String message, Throwable cause) {
        super(message, cause);
    }

    public WalletWithNameAlreadyExistInDb(Throwable cause) {
        super(cause);
    }

    protected WalletWithNameAlreadyExistInDb(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

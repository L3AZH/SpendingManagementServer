package com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions;

public class NoneBudgetFoundWithUUIDWalletException extends Exception{
    public NoneBudgetFoundWithUUIDWalletException() {
        super();
    }

    public NoneBudgetFoundWithUUIDWalletException(String message) {
        super(message);
    }

    public NoneBudgetFoundWithUUIDWalletException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoneBudgetFoundWithUUIDWalletException(Throwable cause) {
        super(cause);
    }

    protected NoneBudgetFoundWithUUIDWalletException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

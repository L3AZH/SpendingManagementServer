package com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions;

public class NoneBudgetFoundWithUUIDException extends Exception{
    public NoneBudgetFoundWithUUIDException() {
        super();
    }

    public NoneBudgetFoundWithUUIDException(String message) {
        super(message);
    }

    public NoneBudgetFoundWithUUIDException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoneBudgetFoundWithUUIDException(Throwable cause) {
        super(cause);
    }

    protected NoneBudgetFoundWithUUIDException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

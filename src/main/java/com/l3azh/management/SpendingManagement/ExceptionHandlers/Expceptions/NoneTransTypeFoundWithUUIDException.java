package com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions;

public class NoneTransTypeFoundWithUUIDException extends Exception{
    public NoneTransTypeFoundWithUUIDException() {
        super();
    }

    public NoneTransTypeFoundWithUUIDException(String message) {
        super(message);
    }

    public NoneTransTypeFoundWithUUIDException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoneTransTypeFoundWithUUIDException(Throwable cause) {
        super(cause);
    }

    protected NoneTransTypeFoundWithUUIDException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

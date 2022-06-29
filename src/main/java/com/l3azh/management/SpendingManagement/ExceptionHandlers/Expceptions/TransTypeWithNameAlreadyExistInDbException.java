package com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions;

public class TransTypeWithNameAlreadyExistInDbException extends Exception{
    public TransTypeWithNameAlreadyExistInDbException() {
        super();
    }

    public TransTypeWithNameAlreadyExistInDbException(String message) {
        super(message);
    }

    public TransTypeWithNameAlreadyExistInDbException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransTypeWithNameAlreadyExistInDbException(Throwable cause) {
        super(cause);
    }

    protected TransTypeWithNameAlreadyExistInDbException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

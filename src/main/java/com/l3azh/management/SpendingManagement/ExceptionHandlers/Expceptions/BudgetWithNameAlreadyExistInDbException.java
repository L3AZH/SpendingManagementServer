package com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions;

public class BudgetWithNameAlreadyExistInDbException extends Exception{
    public BudgetWithNameAlreadyExistInDbException() {
        super();
    }

    public BudgetWithNameAlreadyExistInDbException(String message) {
        super(message);
    }

    public BudgetWithNameAlreadyExistInDbException(String message, Throwable cause) {
        super(message, cause);
    }

    public BudgetWithNameAlreadyExistInDbException(Throwable cause) {
        super(cause);
    }

    protected BudgetWithNameAlreadyExistInDbException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

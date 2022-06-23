package com.l3azh.management.SpendingManagement.ExceptionHandlers;

import com.l3azh.management.SpendingManagement.Dtos.ErrorResponseDto;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.AccountAlreadyExistException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.AccountWithEmailNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;

public interface IAccountExceptionHandler {
    ResponseEntity<ErrorResponseDto> handleAccountAlreadyExistException(AccountAlreadyExistException e);
    ResponseEntity<ErrorResponseDto> handleBadCredentialsException(BadCredentialsException e);
    ResponseEntity<ErrorResponseDto> handleAccountWithEmailNotFound(AccountWithEmailNotFoundException e);
}

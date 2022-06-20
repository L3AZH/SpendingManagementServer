package com.l3azh.management.SpendingManagement.ExceptionHandlers;

import com.l3azh.management.SpendingManagement.Dtos.BaseResponseDto;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.AccountAlreadyExistException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.AccountWithEmailNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;

public interface IAccountExceptionHandler {
    ResponseEntity<BaseResponseDto<String>> handleAccountAlreadyExistException(AccountAlreadyExistException e);
    ResponseEntity<BaseResponseDto<String>> handleBadCredentialsException(BadCredentialsException e);
    ResponseEntity<BaseResponseDto<String>> handleAccountWithEmailNotFound(AccountWithEmailNotFoundException e);
}

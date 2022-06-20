package com.l3azh.management.SpendingManagement.ExceptionHandlers;

import com.l3azh.management.SpendingManagement.Dtos.BaseResponseDto;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.AccountAlreadyExistException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.AccountWithEmailNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler implements IAccountExceptionHandler {

    private static final Logger exceptionLog = LoggerFactory.getLogger(GlobalExceptionHandler.class.getName());

    /**
     * Valid field request exception handler
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponseDto<Map<String, String>>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        BaseResponseDto<Map<String, String>> errorResponse =
                new BaseResponseDto<>(HttpStatus.BAD_REQUEST.value(), false, errors);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle General Exception for Server
     * @param e
     * @return
     */

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<BaseResponseDto<String>> handleBadCredentialsException(BadCredentialsException e) {
        BaseResponseDto<String> errorResponse =
                new BaseResponseDto<>(HttpStatus.BAD_REQUEST.value(), false, "Email or Password not correct !");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponseDto<String>> handleServerException(Exception e){
        exceptionLog.error(e.getMessage());
        e.printStackTrace();
        BaseResponseDto<String> errorResponse =
                new BaseResponseDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), false, "Internal Server Error");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Account Exception
     * @param e
     * @return
     */

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AccountAlreadyExistException.class)
    public ResponseEntity<BaseResponseDto<String>> handleAccountAlreadyExistException(AccountAlreadyExistException e) {
        BaseResponseDto<String> errorResponse =
                new BaseResponseDto<>(HttpStatus.BAD_REQUEST.value(), false, e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<BaseResponseDto<String>> handleAccountWithEmailNotFound(AccountWithEmailNotFoundException e) {
        BaseResponseDto<String> errorResponse =
                new BaseResponseDto<>(HttpStatus.BAD_REQUEST.value(), false, e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}

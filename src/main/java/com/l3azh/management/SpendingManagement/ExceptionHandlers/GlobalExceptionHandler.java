package com.l3azh.management.SpendingManagement.ExceptionHandlers;

import com.l3azh.management.SpendingManagement.Dtos.ErrorResponseDto;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler implements IAccountExceptionHandler, IWalletExceptionHandler, ITransactionExceptionHandler, ITransTypeExceptionHandler {

    /**
     * Valid field request exception handler
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        String errorMessageResponse = "None";
        if (ex.getBindingResult().getAllErrors().size() > 0) {
            ObjectError error = ex.getBindingResult().getAllErrors().get(0);
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorMessageResponse = fieldName + " - " + errorMessage;
        }
        return new ResponseEntity<>(
                ErrorResponseDto.builder()
                        .code(HttpStatus.BAD_REQUEST.value())
                        .flag(false)
                        .errorMessage(errorMessageResponse)
                        .build(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle General Exception for Server
     *
     * @param e
     * @return
     */

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponseDto> handleBadCredentialsException(BadCredentialsException e) {
        return new ResponseEntity<>(ErrorResponseDto.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .flag(false)
                .errorMessage("Email or Password not correct !")
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleServerException(Exception e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return new ResponseEntity<>(ErrorResponseDto.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .flag(false)
                .errorMessage("Internal Server Error: " + e.getMessage())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Account Exception
     *
     * @param e
     * @return
     */

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AccountAlreadyExistException.class)
    public ResponseEntity<ErrorResponseDto> handleAccountAlreadyExistException(AccountAlreadyExistException e) {
        return new ResponseEntity<>(ErrorResponseDto.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .flag(false)
                .errorMessage(e.getMessage())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AccountWithEmailNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleAccountWithEmailNotFound(AccountWithEmailNotFoundException e) {
        return new ResponseEntity<>(ErrorResponseDto.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .flag(false)
                .errorMessage(e.getMessage())
                .build(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Wallet Exception
     */

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WalletWithNameAlreadyExistInDb.class)
    public ResponseEntity<ErrorResponseDto> handleWalletWithNameAlreadyExistInDbException(WalletWithNameAlreadyExistInDb e) {
        return new ResponseEntity<>(ErrorResponseDto.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .flag(false)
                .errorMessage(e.getMessage())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @Override
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoneWalletFoundWithEmailException.class)
    public ResponseEntity<ErrorResponseDto> handleNoneWalletWithEmailException(NoneWalletFoundWithEmailException e) {
        return new ResponseEntity<>(ErrorResponseDto.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .flag(false)
                .errorMessage(e.getMessage())
                .build(), HttpStatus.NOT_FOUND);
    }

    @Override
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoneWalletFoundWithUUIDException.class)
    public ResponseEntity<ErrorResponseDto> handleNoneWalletFoundWithUUIDException(NoneWalletFoundWithUUIDException e) {
        return new ResponseEntity<>(ErrorResponseDto.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .flag(false)
                .errorMessage(e.getMessage())
                .build(), HttpStatus.NOT_FOUND);
    }

    /**
     * TransType Exception
     */
    @Override
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoneTransTypeFoundWithUUIDException.class)
    public ResponseEntity<ErrorResponseDto> handleNoneTransTypeFoundWithUUIDException(NoneTransTypeFoundWithUUIDException e) {
        return new ResponseEntity<>(ErrorResponseDto.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .flag(false)
                .errorMessage(e.getMessage())
                .build(), HttpStatus.NOT_FOUND);
    }

    /**
     * Transaction Exception
     */

    @Override
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoneTransactionFoundWithUUIDException.class)
    public ResponseEntity<ErrorResponseDto> handleNoneTransactionFoundWithUUIDException(NoneTransactionFoundWithUUIDException e) {
        return new ResponseEntity<>(ErrorResponseDto.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .flag(false)
                .errorMessage(e.getMessage())
                .build(), HttpStatus.NOT_FOUND);
    }

    @Override
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoneTransactionFoundWithUUIDWalletException.class)
    public ResponseEntity<ErrorResponseDto> handleNoneTransactionFoundWithUUIDWalletException(NoneTransactionFoundWithUUIDWalletException e) {
        return new ResponseEntity<>(ErrorResponseDto.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .flag(false)
                .errorMessage(e.getMessage())
                .build(), HttpStatus.NOT_FOUND);
    }
}

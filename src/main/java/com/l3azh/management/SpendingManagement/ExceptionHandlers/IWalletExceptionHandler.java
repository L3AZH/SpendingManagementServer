package com.l3azh.management.SpendingManagement.ExceptionHandlers;

import com.l3azh.management.SpendingManagement.Dtos.ErrorResponseDto;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneWalletFoundWithEmailException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneWalletFoundWithUUIDException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.WalletWithNameAlreadyExistInDb;
import org.springframework.http.ResponseEntity;

public interface IWalletExceptionHandler {

    ResponseEntity<ErrorResponseDto> handleWalletWithNameAlreadyExistInDbException(WalletWithNameAlreadyExistInDb e);
    ResponseEntity<ErrorResponseDto> handleNoneWalletWithEmailException(NoneWalletFoundWithEmailException e);
    ResponseEntity<ErrorResponseDto> handleNoneWalletFoundWithUUIDException(NoneWalletFoundWithUUIDException e);

}

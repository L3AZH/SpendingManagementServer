package com.l3azh.management.SpendingManagement.ExceptionHandlers;

import com.l3azh.management.SpendingManagement.Dtos.BaseResponseDto;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneWalletFoundWithEmailException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.WalletWithNameAlreadyExistInDb;
import org.springframework.http.ResponseEntity;

public interface IWalletExceptionHandler {

    ResponseEntity<BaseResponseDto<String>> handleWalletWithNameAlreadyExistInDbException(WalletWithNameAlreadyExistInDb e);
    ResponseEntity<BaseResponseDto<String>> handleNoneWalletWithEmailException(NoneWalletFoundWithEmailException e);
}

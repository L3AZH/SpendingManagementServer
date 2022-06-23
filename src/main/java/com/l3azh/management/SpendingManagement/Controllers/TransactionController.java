package com.l3azh.management.SpendingManagement.Controllers;

import com.l3azh.management.SpendingManagement.DAOS.ITransactionDao;
import com.l3azh.management.SpendingManagement.Dtos.*;
import com.l3azh.management.SpendingManagement.Dtos.EntitiesDto.TransactionDto;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneTransTypeFoundWithUUIDException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneTransactionFoundWithUUIDException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneTransactionFoundWithUUIDWalletException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneWalletFoundWithUUIDException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final ITransactionDao iTransactionDao;

    @PostMapping(value = "/create-transaction")
    public ResponseEntity<BaseResponseDto<CreateTransactionReponseDto>> createNewTransaction(
            @RequestParam String uuidWallet,
            @Valid @RequestBody CreateTransactionRequestDto requestDto)
            throws NoneWalletFoundWithUUIDException, NoneTransTypeFoundWithUUIDException {
        BaseResponseDto<CreateTransactionReponseDto> responseDto =
                iTransactionDao.createNewTransaction(uuidWallet, requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping(value = "/update-transaction")
    public ResponseEntity<BaseResponseDto<UpdateTransactionResponseDto>> updateTransaction(
            @RequestParam String uuidTransaction,
            @Valid @RequestBody UpdateTransactionRequestDto requestDto
    ) throws NoneTransactionFoundWithUUIDException, NoneTransTypeFoundWithUUIDException {
        BaseResponseDto<UpdateTransactionResponseDto> responseDto = iTransactionDao.updateTransaction(uuidTransaction, requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping(value = "/list-transaction")
    public ResponseEntity<BaseResponseDto<List<TransactionDto>>> getListTransactionOfWallet(
            @RequestParam String uuidWallet
    ) throws NoneWalletFoundWithUUIDException, NoneTransactionFoundWithUUIDWalletException {
        BaseResponseDto<List<TransactionDto>> responseDto = iTransactionDao.getListTransactionOfWallet(uuidWallet);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}

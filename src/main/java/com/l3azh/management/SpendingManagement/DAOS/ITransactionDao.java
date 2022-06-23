package com.l3azh.management.SpendingManagement.DAOS;

import com.l3azh.management.SpendingManagement.Dtos.*;
import com.l3azh.management.SpendingManagement.Dtos.EntitiesDto.TransactionDto;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneTransTypeFoundWithUUIDException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneTransactionFoundWithUUIDException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneTransactionFoundWithUUIDWalletException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneWalletFoundWithUUIDException;

import java.util.List;

public interface ITransactionDao {

    BaseResponseDto<CreateTransactionReponseDto> createNewTransaction(String uuidWallet, CreateTransactionRequestDto requestDto)
            throws NoneWalletFoundWithUUIDException, NoneTransTypeFoundWithUUIDException;

    BaseResponseDto<UpdateTransactionResponseDto> updateTransaction(String uuidTransaction, UpdateTransactionRequestDto requestDto)
            throws NoneTransactionFoundWithUUIDException, NoneTransTypeFoundWithUUIDException;

    BaseResponseDto<List<TransactionDto>> getListTransactionOfWallet(String uuidWallet)
            throws NoneWalletFoundWithUUIDException, NoneTransactionFoundWithUUIDWalletException;
}

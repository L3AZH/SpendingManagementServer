package com.l3azh.management.SpendingManagement.DAOS;

import com.l3azh.management.SpendingManagement.Dtos.*;
import com.l3azh.management.SpendingManagement.Dtos.EntitiesDto.WalletDto;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.AccountWithEmailNotFoundException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneWalletFoundWithEmailException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.WalletWithNameAlreadyExistInDb;

import java.util.List;

public interface IWalletDao {
    BaseResponseDto<CreateWalletResponseDto> createNewWallet(String email, CreateWalletRequestDto requestDto)
            throws AccountWithEmailNotFoundException, WalletWithNameAlreadyExistInDb;

    BaseResponseDto<UpdateWalletResponseDto> updateWallet(String email, UpdateWalletRequestDto requestDto)
            throws AccountWithEmailNotFoundException, WalletWithNameAlreadyExistInDb;

    BaseResponseDto<List<WalletDto>> getListWalletOfAccount(String email)
            throws AccountWithEmailNotFoundException, NoneWalletFoundWithEmailException;
}

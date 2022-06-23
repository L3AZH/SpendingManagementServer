package com.l3azh.management.SpendingManagement.DAOS;

import com.l3azh.management.SpendingManagement.Dtos.*;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.AccountAlreadyExistException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.AccountWithEmailNotFoundException;

public interface IAccountDao {
    BaseResponseDto<CreateAccountResponseDto> createNewAccount(CreateAccountRequestDto requestDto) throws AccountAlreadyExistException;
    BaseResponseDto<InfoAccountResponseDto> getAccountInfo(String email) throws AccountWithEmailNotFoundException;
    BaseResponseDto<UpdateAccountResponseDto> updateAccountInfo(String email, UpdateAccountRequestDto requestDto) throws AccountWithEmailNotFoundException;
}

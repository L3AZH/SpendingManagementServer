package com.l3azh.management.SpendingManagement.DAOS;

import com.l3azh.management.SpendingManagement.Dtos.BaseResponseDto;
import com.l3azh.management.SpendingManagement.Dtos.CreateAccountRequestDto;
import com.l3azh.management.SpendingManagement.Dtos.CreateAccountResponseDto;
import com.l3azh.management.SpendingManagement.Dtos.LoginRequestDto;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.AccountAlreadyExistException;

public interface IAccountDao {
    BaseResponseDto<CreateAccountResponseDto> createNewAccount(CreateAccountRequestDto requestDto) throws AccountAlreadyExistException;
}

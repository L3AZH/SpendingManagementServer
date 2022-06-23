package com.l3azh.management.SpendingManagement.DAOS;

import com.l3azh.management.SpendingManagement.Dtos.BaseResponseDto;
import com.l3azh.management.SpendingManagement.Dtos.CreateAccountRequestDto;
import com.l3azh.management.SpendingManagement.Dtos.CreateTransTypeRequestDto;


public interface ITransTypeDao {
    BaseResponseDto<CreateTransTypeRequestDto> createNewTransType(CreateAccountRequestDto requestDto);
}

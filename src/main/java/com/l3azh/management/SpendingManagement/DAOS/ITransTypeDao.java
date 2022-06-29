package com.l3azh.management.SpendingManagement.DAOS;

import com.l3azh.management.SpendingManagement.Dtos.*;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneTransTypeFoundWithUUIDException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.TransTypeWithNameAlreadyExistInDbException;


public interface ITransTypeDao {
    BaseResponseDto<CreateTransTypeResponseDto> createNewTransType(CreateTransTypeRequestDto requestDto)
            throws TransTypeWithNameAlreadyExistInDbException;

    BaseResponseDto<UpdateTransTypeResponseDto> updateTransType(String uuidTransType, UpdateTransTypeRequestDto requestDto)
            throws NoneTransTypeFoundWithUUIDException, TransTypeWithNameAlreadyExistInDbException;
}

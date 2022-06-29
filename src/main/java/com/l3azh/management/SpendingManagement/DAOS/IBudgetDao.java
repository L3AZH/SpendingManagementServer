package com.l3azh.management.SpendingManagement.DAOS;

import com.l3azh.management.SpendingManagement.Dtos.*;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.BudgetWithNameAlreadyExistInDbException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneBudgetFoundWithUUIDException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneWalletFoundWithUUIDException;

public interface IBudgetDao {
    BaseResponseDto<CreateBudgetResponseDto> createNewBudget(String uuidWallet, CreateBudgetRequestDto requestDto)
            throws NoneWalletFoundWithUUIDException, BudgetWithNameAlreadyExistInDbException;

    BaseResponseDto<UpdateBudgetResponseDto> updateBudget(String uuidBudget, UpdateBudgetRequestDto requestDto)
            throws NoneBudgetFoundWithUUIDException, BudgetWithNameAlreadyExistInDbException;
}

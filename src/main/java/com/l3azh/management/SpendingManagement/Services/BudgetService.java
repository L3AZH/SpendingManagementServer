package com.l3azh.management.SpendingManagement.Services;

import com.l3azh.management.SpendingManagement.DAOS.IBudgetDao;
import com.l3azh.management.SpendingManagement.Dtos.*;
import com.l3azh.management.SpendingManagement.Entities.BudgetEntity;
import com.l3azh.management.SpendingManagement.Entities.WalletEntity;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.BudgetWithNameAlreadyExistInDbException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneBudgetFoundWithUUIDException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneBudgetFoundWithUUIDWalletException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneWalletFoundWithUUIDException;
import com.l3azh.management.SpendingManagement.Repositories.IBudgetRepository;
import com.l3azh.management.SpendingManagement.Repositories.IWalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BudgetService implements IBudgetDao {

    private final IBudgetRepository iBudgetRepository;
    private final IWalletRepository iWalletRepository;

    @Override
    @Transactional
    public BaseResponseDto<CreateBudgetResponseDto> createNewBudget(String uuidWallet, CreateBudgetRequestDto requestDto)
            throws NoneWalletFoundWithUUIDException, BudgetWithNameAlreadyExistInDbException {
        Optional<WalletEntity> walletResultObject = iWalletRepository.findById(UUID.fromString(uuidWallet));
        if (walletResultObject.isEmpty()) {
            throw new NoneWalletFoundWithUUIDException("Can not found any wallet with this uuid: " + uuidWallet);
        }
        WalletEntity walletEntity = walletResultObject.get();
        Optional<List<BudgetEntity>> listBudgetResultObject =
                iBudgetRepository.getListBudgetByName(requestDto.getName());
        if (listBudgetResultObject.isPresent()) {
            throw new BudgetWithNameAlreadyExistInDbException("Budget with this name already exist in db !");
        }
        BudgetEntity newBudget = BudgetEntity.builder()
                .name(requestDto.getName())
                .description(requestDto.getDescription())
                .amountEstimate(requestDto.getAmount())
                .timeNoti(new Date(requestDto.getTimeNoti()))
                .walletOfBudget(walletEntity)
                .build();
        iBudgetRepository.save(newBudget);
        return BaseResponseDto.<CreateBudgetResponseDto>builder()
                .code(HttpStatus.OK.value())
                .flag(true)
                .data(CreateBudgetResponseDto.builder().message("Create new budget successful !").build())
                .build();
    }

    @Override
    @Transactional
    public BaseResponseDto<UpdateBudgetResponseDto> updateBudget(String uuidBudget, UpdateBudgetRequestDto requestDto)
            throws NoneBudgetFoundWithUUIDException, BudgetWithNameAlreadyExistInDbException {
        Optional<BudgetEntity> budgetResultObject = iBudgetRepository.findById(UUID.fromString(uuidBudget));
        if (budgetResultObject.isEmpty()) {
            throw new NoneBudgetFoundWithUUIDException("Can find any budget with this uuid: " + uuidBudget);
        }
        BudgetEntity updateBudget = budgetResultObject.get();
        Optional<List<BudgetEntity>> listBudgetResultObject =
                iBudgetRepository.getListBudgetByName(requestDto.getName());
        if (listBudgetResultObject.isPresent()) {
            throw new BudgetWithNameAlreadyExistInDbException("Budget with this name already exist in db !");
        }
        updateBudget.setName(requestDto.getName());
        updateBudget.setDescription(requestDto.getDescription());
        updateBudget.setAmountEstimate(requestDto.getAmountEstimate());
        updateBudget.setTimeNoti(new Date(requestDto.getTimeNoti()));
        iBudgetRepository.save(updateBudget);
        return BaseResponseDto.<UpdateBudgetResponseDto>builder()
                .code(HttpStatus.OK.value())
                .flag(true)
                .data(UpdateBudgetResponseDto.builder().message("Update new budget successful !").build())
                .build();
    }
}

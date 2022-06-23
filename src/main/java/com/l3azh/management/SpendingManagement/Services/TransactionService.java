package com.l3azh.management.SpendingManagement.Services;


import com.l3azh.management.SpendingManagement.DAOS.ITransactionDao;
import com.l3azh.management.SpendingManagement.Dtos.*;
import com.l3azh.management.SpendingManagement.Dtos.EntitiesDto.TransactionDto;
import com.l3azh.management.SpendingManagement.Entities.TransTypeEntity;
import com.l3azh.management.SpendingManagement.Entities.TransactionEntity;
import com.l3azh.management.SpendingManagement.Entities.WalletEntity;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneTransTypeFoundWithUUIDException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneTransactionFoundWithUUIDException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneTransactionFoundWithUUIDWalletException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneWalletFoundWithUUIDException;
import com.l3azh.management.SpendingManagement.Repositories.ITransTypeRepository;
import com.l3azh.management.SpendingManagement.Repositories.ITransactionRepository;
import com.l3azh.management.SpendingManagement.Repositories.IWalletRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService implements ITransactionDao {


    private final IWalletRepository iWalletRepository;

    private final ITransactionRepository iTransactionRepository;

    private final ITransTypeRepository iTransTypeRepository;

    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public BaseResponseDto<CreateTransactionReponseDto> createNewTransaction(String uuidWallet, CreateTransactionRequestDto requestDto) throws NoneWalletFoundWithUUIDException, NoneTransTypeFoundWithUUIDException {
        Optional<WalletEntity> walletResultObject = iWalletRepository.findById(UUID.fromString(uuidWallet));
        if (walletResultObject.isEmpty()) {
            throw new NoneWalletFoundWithUUIDException("Can not found any wallet with this uuid: " + uuidWallet);
        }
        WalletEntity walletEntity = walletResultObject.get();
        Optional<TransTypeEntity> transTypeResultObject = iTransTypeRepository.findById(UUID.fromString(requestDto.getUuidTransType()));
        if (transTypeResultObject.isEmpty()) {
            throw new NoneTransTypeFoundWithUUIDException("Can not found any trans type with this uuid: " + requestDto.getUuidTransType());
        }
        TransTypeEntity transTypeEntity = transTypeResultObject.get();
        TransactionEntity newTransaction = TransactionEntity.builder()
                .description(requestDto.getDescription())
                .amount(requestDto.getAmount())
                .walletOfTransaction(walletEntity)
                .transType(transTypeEntity)
                .build();
        iTransactionRepository.save(newTransaction);
        return BaseResponseDto.<CreateTransactionReponseDto>builder()
                .code(HttpStatus.OK.value())
                .flag(true)
                .data(CreateTransactionReponseDto.builder().message("Create transaction successful!").build()).build();
    }

    @Override
    @Transactional
    public BaseResponseDto<UpdateTransactionResponseDto> updateTransaction(String uuidTransaction, UpdateTransactionRequestDto requestDto) throws NoneTransactionFoundWithUUIDException, NoneTransTypeFoundWithUUIDException {
        Optional<TransactionEntity> transactionResultObject = iTransactionRepository.findById(UUID.fromString(uuidTransaction));
        if (transactionResultObject.isEmpty()) {
            throw new NoneTransactionFoundWithUUIDException("Can not found any transaction with this uuid: " + uuidTransaction);
        }
        TransactionEntity transactionEntity = transactionResultObject.get();
        Optional<TransTypeEntity> transTypeResultObject = iTransTypeRepository.findById(UUID.fromString(requestDto.getUuidTransType()));
        if (transTypeResultObject.isEmpty()) {
            throw new NoneTransTypeFoundWithUUIDException("Can not found any trans type with this uuid: " + requestDto.getUuidTransType());
        }
        TransTypeEntity transTypeEntity = transTypeResultObject.get();
        transactionEntity.setAmount(requestDto.getAmount());
        transactionEntity.setDescription(requestDto.getDescription());
        transactionEntity.setCreateDate(new Date(requestDto.getCreateDate()));
        transactionEntity.setTransType(transTypeEntity);
        iTransactionRepository.save(transactionEntity);
        return BaseResponseDto.<UpdateTransactionResponseDto>builder()
                .code(HttpStatus.OK.value())
                .flag(true)
                .data(UpdateTransactionResponseDto.builder().message("Update transaction successful !").build()).build();
    }

    @Override
    public BaseResponseDto<List<TransactionDto>> getListTransactionOfWallet(String uuidWallet) throws NoneWalletFoundWithUUIDException, NoneTransactionFoundWithUUIDWalletException {
        Optional<WalletEntity> walletResultObject = iWalletRepository.findById(UUID.fromString(uuidWallet));
        if (walletResultObject.isEmpty()) {
            throw new NoneWalletFoundWithUUIDException("Can not found any wallet with this uuid: " + uuidWallet);
        }
        Optional<List<TransactionEntity>> listTransactionResultObject =
                iTransactionRepository.getListTransactionByUUIDWallet(uuidWallet);
        if (listTransactionResultObject.isEmpty()) {
            throw new NoneTransactionFoundWithUUIDWalletException("Can not found any transaction with wallet's uuid: " + uuidWallet);
        }
        List<TransactionEntity> listTransactionEntity = listTransactionResultObject.get();
        if (listTransactionEntity.isEmpty()) {
            throw new NoneTransactionFoundWithUUIDWalletException("Can not found any transaction with wallet's uuid: " + uuidWallet);
        }
        List<TransactionDto> listTransactionDto = listTransactionEntity.stream().map(transactionEntity -> {
            return modelMapper.map(transactionEntity, TransactionDto.class);
        }).collect(Collectors.toList());
        return BaseResponseDto.<List<TransactionDto>>builder()
                .code(HttpStatus.OK.value())
                .flag(true)
                .data(listTransactionDto).build();
    }
}

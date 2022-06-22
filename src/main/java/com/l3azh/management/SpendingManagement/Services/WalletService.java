package com.l3azh.management.SpendingManagement.Services;

import com.l3azh.management.SpendingManagement.DAOS.IWalletDao;
import com.l3azh.management.SpendingManagement.Dtos.*;
import com.l3azh.management.SpendingManagement.Dtos.EntitiesDto.WalletDto;
import com.l3azh.management.SpendingManagement.Entities.AccountEntity;
import com.l3azh.management.SpendingManagement.Entities.WalletEntity;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.AccountWithEmailNotFoundException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneWalletFoundWithEmailException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.WalletWithNameAlreadyExistInDb;
import com.l3azh.management.SpendingManagement.Repositories.IAccountRepository;
import com.l3azh.management.SpendingManagement.Repositories.IWalletRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WalletService implements IWalletDao {

    @Autowired
    IWalletRepository walletRepository;
    @Autowired
    IAccountRepository accountRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    @Transactional
    public BaseResponseDto<CreateWalletResponseDto> createNewWallet(String email, CreateWalletRequestDto requestDto)
            throws AccountWithEmailNotFoundException, WalletWithNameAlreadyExistInDb {
        Optional<AccountEntity> accountResultObject = accountRepository.findById(email);
        if(accountResultObject.isEmpty()){
            throw new AccountWithEmailNotFoundException("Can not find any account with this email: "+ email);
        }
        AccountEntity account = accountResultObject.get();
        Optional<List<WalletEntity>> listWalletWithName = walletRepository.getListWalletOfTheAccountByName(email, requestDto.getName());
        if(listWalletWithName.isPresent() && listWalletWithName.get().size() > 0){
            throw new WalletWithNameAlreadyExistInDb("The name wallet you create already exist in db!");
        }

        WalletEntity newWallet = new WalletEntity(requestDto.getName(), requestDto.getDescription(), account);
        walletRepository.save(newWallet);
        return new BaseResponseDto<>(
                HttpStatus.OK.value(), true, new CreateWalletResponseDto("Create new wallet successful !"));
    }

    @Override
    @Transactional
    public BaseResponseDto<UpdateWalletResponseDto> updateWallet(String email, UpdateWalletRequestDto requestDto) throws AccountWithEmailNotFoundException, WalletWithNameAlreadyExistInDb {
        Optional<AccountEntity> accountResultObject = accountRepository.findById(email);
        if(accountResultObject.isEmpty()){
            throw new AccountWithEmailNotFoundException("Can not find any account with this email: "+ email);
        }
        AccountEntity account = accountResultObject.get();
        Optional<List<WalletEntity>> listWalletWithName = walletRepository.getListWalletOfTheAccountByName(email, requestDto.getName());
        if(listWalletWithName.isEmpty()){
            throw new WalletWithNameAlreadyExistInDb("The name wallet you create already exist in db!");
        }

        WalletEntity newWallet = new WalletEntity(requestDto.getName(), requestDto.getDescription(), account);
        walletRepository.save(newWallet);
        return new BaseResponseDto<>(
                HttpStatus.OK.value(), true, new UpdateWalletResponseDto("Create new wallet successful !"));
    }

    @Override
    @Transactional
    public BaseResponseDto<List<WalletDto>> getListWalletOfAccount(String email)
            throws AccountWithEmailNotFoundException, NoneWalletFoundWithEmailException {
        Optional<AccountEntity> accountResultObject = accountRepository.findById(email);
        if(accountResultObject.isEmpty()){
            throw new AccountWithEmailNotFoundException("Can not find any account with this email: "+ email);
        }
        Optional<List<WalletEntity>> listWalletObjectResult = walletRepository.findListWalletByAccountEmail(email);
        if(listWalletObjectResult.isEmpty()){
            throw new NoneWalletFoundWithEmailException("Can not found any wallet !");
        }
        List<WalletEntity> listWalletEntities = listWalletObjectResult.get();
        if(listWalletEntities.size() == 0){
            throw new NoneWalletFoundWithEmailException("Can not found any wallet !");
        }
        List<WalletDto> listWalletDtos = listWalletEntities.stream().map(walletEntity -> {
             return modelMapper.map(walletEntity, WalletDto.class);
        }).collect(Collectors.toList());
        return new BaseResponseDto<>(HttpStatus.OK.value(), true, listWalletDtos);
    }
}

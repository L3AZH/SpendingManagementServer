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
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WalletService implements IWalletDao {

    private final IWalletRepository walletRepository;
    private final IAccountRepository accountRepository;

    private final ModelMapper modelMapper;

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

        WalletEntity newWallet = WalletEntity.builder()
                .name(requestDto.getName())
                .description(requestDto.getDescription())
                .account(account).build();
        walletRepository.save(newWallet);
        return BaseResponseDto.<CreateWalletResponseDto>builder()
                .code(HttpStatus.OK.value())
                .flag(true)
                .data(CreateWalletResponseDto.builder().message("Created wallet successful !").build()).build();
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

        WalletEntity updateWallet = WalletEntity.builder()
                .name(requestDto.getName())
                .description(requestDto.getDescription())
                .account(account).build();
        walletRepository.save(updateWallet);
        return BaseResponseDto.<UpdateWalletResponseDto>builder()
                .code(HttpStatus.OK.value())
                .flag(true)
                .data(UpdateWalletResponseDto.builder().message("Updated wallet successful !").build()).build();
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
        List<WalletDto> listWalletDtos = listWalletEntities.stream()
                .map(walletEntity -> modelMapper.map(walletEntity, WalletDto.class)).collect(Collectors.toList());
        return BaseResponseDto.<List<WalletDto>>builder()
                .code(HttpStatus.OK.value())
                .flag(true)
                .data(listWalletDtos).build();
    }
}

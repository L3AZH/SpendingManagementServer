package com.l3azh.management.SpendingManagement.Services;

import com.l3azh.management.SpendingManagement.DAOS.IAccountDao;
import com.l3azh.management.SpendingManagement.Dtos.*;
import com.l3azh.management.SpendingManagement.Entities.AccountEntity;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.AccountAlreadyExistException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.AccountWithEmailNotFoundException;
import com.l3azh.management.SpendingManagement.Repositories.IAccountRepository;
import com.l3azh.management.SpendingManagement.Utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.Optional;

@Service
public class AccountService implements IAccountDao {

    @Autowired
    IAccountRepository accountRepository;

    @Autowired
    ApplicationContext applicationContext;

    @Override
    @Transactional
    public BaseResponseDto<CreateAccountResponseDto> createNewAccount(CreateAccountRequestDto requestDto)
            throws AccountAlreadyExistException {
        /**
         * Check email exist in db
         */
        Optional<AccountEntity> accountExist = accountRepository.findById(requestDto.getEmail());
        if(accountExist.isPresent()){
            throw new AccountAlreadyExistException("Account with this email already exist in database !");
        }
        /**
         * Check if user request an avatar
         */
        byte[] avatar = null;
        if(requestDto.getAvatar() != null){
            if(requestDto.getAvatar().length() > 0){
                avatar = Base64.getDecoder().decode(requestDto.getAvatar());
            }
        }
        /**
         * Create new account
         */
        String passwordEncode =  applicationContext.getBean(
                "passwordEncoder",
                BCryptPasswordEncoder.class).encode(requestDto.getPassword());
        AccountEntity newAccount;
        if(avatar != null && avatar.length > 0) {
            newAccount = new AccountEntity(
                    requestDto.getEmail(),
                    passwordEncode,
                    requestDto.getFirstName(),
                    requestDto.getLastName(),
                    requestDto.getPhonenumber(),
                    avatar);
        } else {
            newAccount = new AccountEntity(
                    requestDto.getEmail(),
                    passwordEncode,
                    requestDto.getFirstName(),
                    requestDto.getLastName(),
                    requestDto.getPhonenumber());
        }
        accountRepository.save(newAccount);
        return new BaseResponseDto<CreateAccountResponseDto>(
                HttpStatus.OK.value(),
                true,
                new CreateAccountResponseDto("Create account successful !"));
    }

    @Override
    public BaseResponseDto<InfoAccountResponseDto> getAccountInfo(String email) throws AccountWithEmailNotFoundException {
        Optional<AccountEntity> result = accountRepository.findById(email);
        AccountEntity accountInfo = null;
        if(result.isEmpty()){
            throw new AccountWithEmailNotFoundException("Can not found any account with this email: " + email);
        }
        accountInfo = result.get();
        return new BaseResponseDto<InfoAccountResponseDto>(
                HttpStatus.OK.value(),
                true,
                new InfoAccountResponseDto(
                        accountInfo.getEmail(),
                        accountInfo.getFirstName(),
                        accountInfo.getLastName(),
                        accountInfo.getPhonenumber(),
                        AppUtils.convertByteToBase64String(accountInfo.getAvatarPic())
                ));
    }
}

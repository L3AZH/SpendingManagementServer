package com.l3azh.management.SpendingManagement.Services;

import com.l3azh.management.SpendingManagement.Config.UserDetailImpl;
import com.l3azh.management.SpendingManagement.Entities.AccountEntity;
import com.l3azh.management.SpendingManagement.Repositories.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailImplService implements UserDetailsService {

    @Autowired
    IAccountRepository accountRepository;

    @Override
    public UserDetailImpl loadUserByUsername(String email) throws UsernameNotFoundException {
        AccountEntity accountEntity = accountRepository.findById(email)
                .orElseThrow(() -> new UsernameNotFoundException("Not found any account with this email"));
        return UserDetailImpl.create(accountEntity, UserDetailImpl.AccCusRole.USER);
    }
}

package com.l3azh.management.SpendingManagement.Services;

import com.l3azh.management.SpendingManagement.Config.UserDetailImpl;
import com.l3azh.management.SpendingManagement.Entities.AccountEntity;
import com.l3azh.management.SpendingManagement.Repositories.IAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailImplService implements UserDetailsService {

    private final IAccountRepository iAccountRepository;

    @Override
    public UserDetailImpl loadUserByUsername(String email) throws UsernameNotFoundException {
        AccountEntity accountEntity = iAccountRepository.findById(email)
                .orElseThrow(() -> new UsernameNotFoundException("Not found any account with this email"));
        return UserDetailImpl.create(accountEntity, UserDetailImpl.AccCusRole.USER);
    }
}

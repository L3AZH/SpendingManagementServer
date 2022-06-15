package com.l3azh.management.SpendingManagement.Repositories;

import com.l3azh.management.SpendingManagement.Entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<AccountEntity, String> {
}

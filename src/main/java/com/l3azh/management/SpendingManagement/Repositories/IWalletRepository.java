package com.l3azh.management.SpendingManagement.Repositories;

import com.l3azh.management.SpendingManagement.Entities.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IWalletRepository extends JpaRepository<WalletEntity, UUID> {
}

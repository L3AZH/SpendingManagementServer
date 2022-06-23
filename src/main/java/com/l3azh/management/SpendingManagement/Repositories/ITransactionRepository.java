package com.l3azh.management.SpendingManagement.Repositories;

import com.l3azh.management.SpendingManagement.Entities.TransactionEntity;
import com.l3azh.management.SpendingManagement.Entities.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ITransactionRepository extends JpaRepository<TransactionEntity, UUID> {
    @Query("FROM TransactionEntity transaction INNER JOIN WalletEntity wa WHERE wa.uuidWallet = :uuidWallet")
    Optional<List<TransactionEntity>> getListTransactionByUUIDWallet(String uuidWallet);
}

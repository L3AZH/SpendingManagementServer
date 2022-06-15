package com.l3azh.management.SpendingManagement.Repositories;

import com.l3azh.management.SpendingManagement.Entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ITransactionRepository extends JpaRepository<TransactionEntity, UUID> {
}

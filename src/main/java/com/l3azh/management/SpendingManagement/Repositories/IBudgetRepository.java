package com.l3azh.management.SpendingManagement.Repositories;

import com.l3azh.management.SpendingManagement.Entities.BudgetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IBudgetRepository extends JpaRepository<BudgetEntity, UUID> {


    @Query(
            nativeQuery = true,
            value = "SELECT * FROM budget bd WHERE bd.Name = :nameBudget"
    )
    Optional<List<BudgetEntity>> getListBudgetByName(String nameBudget);

    @Query(
            nativeQuery = true,
            value = "SELECT * " +
                    "FROM budget bd INNER JOIN wallet wa ON wa.UUID_wallet = bd.FK_Wallet_UUID_wallet " +
                    "WHERE wa.UUID_wallet = :uuidWallet "
    )
    Optional<List<BudgetEntity>> getListBudgetByUUIDWallet(String uuidWallet);
}

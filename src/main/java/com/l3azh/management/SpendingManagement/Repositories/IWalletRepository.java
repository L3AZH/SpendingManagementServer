package com.l3azh.management.SpendingManagement.Repositories;

import com.l3azh.management.SpendingManagement.Entities.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IWalletRepository extends JpaRepository<WalletEntity, UUID> {

    @Query(
            nativeQuery = true,
            value = "SELECT wallet.* " +
                    "FROM wallet INNER JOIN account ON account.Email = wallet.FK_Account_Email " +
                    "WHERE account.Email = :email AND wallet.Name = :nameWallet"
    )
    Optional<List<WalletEntity>> getListWalletOfTheAccountByName(String email, String nameWallet);

    @Query(
            nativeQuery = true,
            value = "SELECT wallet.* " +
                    "FROM wallet INNER JOIN account ON account.Email = wallet.FK_Account_Email " +
                    "WHERE account.Email = :email"
    )
    Optional<List<WalletEntity>> findListWalletByAccountEmail(@Param(value = "email") String email);
}

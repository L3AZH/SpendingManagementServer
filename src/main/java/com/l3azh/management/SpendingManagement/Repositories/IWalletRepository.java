package com.l3azh.management.SpendingManagement.Repositories;

import com.l3azh.management.SpendingManagement.Entities.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IWalletRepository extends JpaRepository<WalletEntity, UUID> {

    @Query("FROM WalletEntity wa LEFT JOIN AccountEntity acc" +
            " WHERE acc.email = :email AND wa.name = :nameWallet")
    Optional<List<WalletEntity>> getListWalletOfTheAccountByName(String email, String nameWallet);

    @Query("FROM WalletEntity wa LEFT JOIN AccountEntity acc " +
            "WHERE acc.email = :email")
    Optional<List<WalletEntity>> findListWalletByAccountEmail(String email);
}

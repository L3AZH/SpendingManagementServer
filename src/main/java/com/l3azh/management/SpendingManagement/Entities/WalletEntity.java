package com.l3azh.management.SpendingManagement.Entities;

import com.l3azh.management.SpendingManagement.Utils.AppUtils;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Wallet")
@Data
@Builder
public class WalletEntity {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "UUID_wallet", columnDefinition = "VARCHAR(50)")
    private UUID uuidWallet;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "CreateDate")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "FK_Account_Email")
    private AccountEntity account;

    @OneToMany(mappedBy = "walletOfBudget")
    private List<BudgetEntity> listBudget;

    @OneToMany(mappedBy = "walletOfTransaction")
    private List<TransactionEntity> listTransaction;

}

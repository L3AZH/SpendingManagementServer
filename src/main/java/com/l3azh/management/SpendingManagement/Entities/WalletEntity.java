package com.l3azh.management.SpendingManagement.Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Wallet")
public class WalletEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "UUID_wallet")
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

    public WalletEntity() {}

    public WalletEntity(UUID uuidWallet, String name, String description, Date createDate, AccountEntity account) {
        this.uuidWallet = uuidWallet;
        this.name = name;
        this.description = description;
        this.createDate = createDate;
        this.account = account;
    }

    public UUID getUuidWallet() {
        return uuidWallet;
    }

    public void setUuidWallet(UUID uuidWallet) {
        this.uuidWallet = uuidWallet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public List<BudgetEntity> getListBudget() {
        return listBudget;
    }

    public void setListBudget(List<BudgetEntity> listBudget) {
        this.listBudget = listBudget;
    }

    public List<TransactionEntity> getListTransaction() {
        return listTransaction;
    }

    public void setListTransaction(List<TransactionEntity> listTransaction) {
        this.listTransaction = listTransaction;
    }
}

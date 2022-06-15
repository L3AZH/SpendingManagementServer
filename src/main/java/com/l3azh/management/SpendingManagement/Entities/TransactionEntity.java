package com.l3azh.management.SpendingManagement.Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Transaction")
public class TransactionEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "UUID_transaction")
    private UUID uuidTransaction;

    @Column(name = "Description")
    private String description;

    @Column(name = "Amount")
    private Double amount;

    @Column(name = "CreateDate")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "FK_Wallet_UUID_wallet")
    private WalletEntity walletOfTransaction;

    @ManyToOne
    @JoinColumn(name = "FK_TransType_UUID_transType")
    private TransTypeEntity transType;

    public TransactionEntity() {
    }

    public TransactionEntity(UUID uuidTransaction, String description, Double amount, Date createDate, WalletEntity walletOfTransaction, TransTypeEntity transType) {
        this.uuidTransaction = uuidTransaction;
        this.description = description;
        this.amount = amount;
        this.createDate = createDate;
        this.walletOfTransaction = walletOfTransaction;
        this.transType = transType;
    }

    public UUID getUuidTransaction() {
        return uuidTransaction;
    }

    public void setUuidTransaction(UUID uuidTransaction) {
        this.uuidTransaction = uuidTransaction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public WalletEntity getWalletOfTransaction() {
        return walletOfTransaction;
    }

    public void setWalletOfTransaction(WalletEntity walletOfTransaction) {
        this.walletOfTransaction = walletOfTransaction;
    }

    public TransTypeEntity getTransType() {
        return transType;
    }

    public void setTransType(TransTypeEntity transType) {
        this.transType = transType;
    }
}

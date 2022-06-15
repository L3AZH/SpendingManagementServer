package com.l3azh.management.SpendingManagement.Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Budget")
public class BudgetEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "UUID_budget")
    private UUID uuidBudget;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "AmountEstimate")
    private Double amountEstimate;

    @Column(name = "TimeNoti")
    private Date timeNoti;

    @Column(name = "CreateDate")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "FK_Wallet_UUID_wallet")
    private WalletEntity walletOfBudget;

    public BudgetEntity() {
    }

    public BudgetEntity(UUID uuidBudget, String name, String description, Double amountEstimate, Date timeNoti, Date createDate) {
        this.uuidBudget = uuidBudget;
        this.name = name;
        this.description = description;
        this.amountEstimate = amountEstimate;
        this.timeNoti = timeNoti;
        this.createDate = createDate;
    }

    public BudgetEntity(UUID uuidBudget, String name, String description, Double amountEstimate, Date timeNoti, Date createDate, WalletEntity walletOfBudget) {
        this.uuidBudget = uuidBudget;
        this.name = name;
        this.description = description;
        this.amountEstimate = amountEstimate;
        this.timeNoti = timeNoti;
        this.createDate = createDate;
        this.walletOfBudget = walletOfBudget;
    }

    public UUID getUuidBudget() {
        return uuidBudget;
    }

    public void setUuidBudget(UUID uuidBudget) {
        this.uuidBudget = uuidBudget;
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

    public Double getAmountEstimate() {
        return amountEstimate;
    }

    public void setAmountEstimate(Double amountEstimate) {
        this.amountEstimate = amountEstimate;
    }

    public Date getTimeNoti() {
        return timeNoti;
    }

    public void setTimeNoti(Date timeNoti) {
        this.timeNoti = timeNoti;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public WalletEntity getWalletOfBudget() {
        return walletOfBudget;
    }

    public void setWalletOfBudget(WalletEntity walletOfBudget) {
        this.walletOfBudget = walletOfBudget;
    }
}

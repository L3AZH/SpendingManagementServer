package com.l3azh.management.SpendingManagement.Dtos.EntitiesDto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class WalletDto {
    private UUID uuidWallet;
    private String name;
    private String description;
    private long createDate;
    private List<TransactionDto> listTransaction;
    private List<BudgetDto> listBudget;

    public WalletDto() {
    }

    public WalletDto(UUID uuidWallet, String name, String description, long createDate, List<TransactionDto> listTransaction, List<BudgetDto> listBudget) {
        this.uuidWallet = uuidWallet;
        this.name = name;
        this.description = description;
        this.createDate = createDate;
        this.listTransaction = listTransaction;
        this.listBudget = listBudget;
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

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public List<TransactionDto> getListTransaction() {
        return listTransaction;
    }

    public void setListTransaction(List<TransactionDto> listTransaction) {
        this.listTransaction = listTransaction;
    }

    public List<BudgetDto> getListBudget() {
        return listBudget;
    }

    public void setListBudget(List<BudgetDto> listBudget) {
        this.listBudget = listBudget;
    }
}

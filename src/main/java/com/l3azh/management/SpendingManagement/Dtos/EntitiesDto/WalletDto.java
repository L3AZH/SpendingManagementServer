package com.l3azh.management.SpendingManagement.Dtos.EntitiesDto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class WalletDto {
    private UUID uuidWallet;
    private String name;
    private String description;
    private long createDate;
    private List<TransactionDto> listTransaction;
    private List<BudgetDto> listBudget;
}

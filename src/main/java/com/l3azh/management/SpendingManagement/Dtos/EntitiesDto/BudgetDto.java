package com.l3azh.management.SpendingManagement.Dtos.EntitiesDto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class BudgetDto {
    private UUID uuidBudget;
    private String name;
    private String description;
    private Double amountEstimate;
    private long timeNoti;
    private long createDate;
}

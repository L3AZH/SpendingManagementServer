package com.l3azh.management.SpendingManagement.Dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateBudgetRequestDto {
    private String name;
    private String description;
    private Double amountEstimate;
    private long timeNoti;
}

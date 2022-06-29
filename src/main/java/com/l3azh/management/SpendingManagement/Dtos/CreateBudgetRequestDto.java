package com.l3azh.management.SpendingManagement.Dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateBudgetRequestDto {
    private String name;
    private String description;
    private Double amount;
    private long timeNoti;
}

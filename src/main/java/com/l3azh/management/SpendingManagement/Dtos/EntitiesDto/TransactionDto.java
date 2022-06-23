package com.l3azh.management.SpendingManagement.Dtos.EntitiesDto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class TransactionDto {
    private UUID uuidTransaction;
    private String description;
    private Double amount;
    private long createDate;
    private TransTypeDto transType;
}

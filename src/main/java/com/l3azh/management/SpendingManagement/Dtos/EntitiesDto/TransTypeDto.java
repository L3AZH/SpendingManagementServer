package com.l3azh.management.SpendingManagement.Dtos.EntitiesDto;

import lombok.Data;

import java.util.UUID;

@Data
public class TransTypeDto {
    private UUID uuidTransType;
    private String name;
    private long createDate;
}

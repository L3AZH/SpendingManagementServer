package com.l3azh.management.SpendingManagement.Dtos.EntitiesDto;

import lombok.Data;

import java.util.UUID;

@Data
public class TransTypeDto {

    private UUID uuidTransType;
    private String name;
    private long createDate;

    public TransTypeDto() {
    }

    public TransTypeDto(UUID uuidTransType, String name, long createDate) {
        this.uuidTransType = uuidTransType;
        this.name = name;
        this.createDate = createDate;
    }

    public UUID getUuidTransType() {
        return uuidTransType;
    }

    public void setUuidTransType(UUID uuidTransType) {
        this.uuidTransType = uuidTransType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }
}

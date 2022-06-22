package com.l3azh.management.SpendingManagement.Dtos.EntitiesDto;

import lombok.Data;

import java.util.UUID;

@Data
public class BudgetDto {
    private UUID uuidBudget;
    private String name;
    private String description;
    private Double amountEstimate;
    private long timeNoti;
    private long createDate;

    public BudgetDto() {
    }

    public BudgetDto(UUID uuidBudget, String name, String description, Double amountEstimate, long timeNoti, long createDate) {
        this.uuidBudget = uuidBudget;
        this.name = name;
        this.description = description;
        this.amountEstimate = amountEstimate;
        this.timeNoti = timeNoti;
        this.createDate = createDate;
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

    public long getTimeNoti() {
        return timeNoti;
    }

    public void setTimeNoti(long timeNoti) {
        this.timeNoti = timeNoti;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }
}

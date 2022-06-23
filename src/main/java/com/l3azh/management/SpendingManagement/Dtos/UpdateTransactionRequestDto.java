package com.l3azh.management.SpendingManagement.Dtos;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
@Data
@Builder
public class UpdateTransactionRequestDto {
    @Size(max = 100, message = "The limit of description is 100 character !")
    private String description;
    @Min(value = 0, message = "The amount can not be negative !")
    @NotNull(message = "Please enter the amount of transaction !")
    private Double amount;
    private long createDate;
    @NotNull(message = "Please enter the uuid trans type for your transaction !")
    @NotEmpty(message = "Please enter the uuid trans type for your transaction !")
    @NotBlank(message = "Please enter the uuid trans type for your transaction !")
    private String uuidTransType;
}

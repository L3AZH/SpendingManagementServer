package com.l3azh.management.SpendingManagement.Dtos;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class UpdateTransTypeRequestDto {
    @NotNull(message = "Please enter your wallet name")
    @NotBlank(message = "Name of wallet can not be blank, please enter your wallet name")
    @NotEmpty(message = "Please enter your wallet name")
    @Size(max = 45, message = "Name of wallet is limit by 45 character !")
    private String name;
    @Size(max = 100, message = "The limit of description is 100 character !")
    private String description;
}

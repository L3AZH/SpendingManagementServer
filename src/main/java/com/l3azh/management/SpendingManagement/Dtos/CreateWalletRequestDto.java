package com.l3azh.management.SpendingManagement.Dtos;


import javax.validation.constraints.*;

public class CreateWalletRequestDto {

    @NotBlank(message = "Name of wallet can not be blank, please enter your wallet name")
    @NotEmpty(message = "Please enter your wallet name")
    @Size(max = 45, message = "Name of wallet is limit by 45 character !")
    private String name;

    @Size(max = 100, message = "The limit of description is 100 character !")
    private String description;

    public CreateWalletRequestDto(){}

    public CreateWalletRequestDto(String name, String description) {
        this.name = name;
        this.description = description == null ? "":description;
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
}

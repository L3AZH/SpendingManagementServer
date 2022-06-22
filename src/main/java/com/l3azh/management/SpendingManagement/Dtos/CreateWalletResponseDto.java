package com.l3azh.management.SpendingManagement.Dtos;

public class CreateWalletResponseDto {
    private String message;

    public CreateWalletResponseDto() {
    }

    public CreateWalletResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

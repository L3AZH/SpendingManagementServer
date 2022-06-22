package com.l3azh.management.SpendingManagement.Dtos;

public class UpdateWalletResponseDto {
    private String message;

    public UpdateWalletResponseDto() {
    }

    public UpdateWalletResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

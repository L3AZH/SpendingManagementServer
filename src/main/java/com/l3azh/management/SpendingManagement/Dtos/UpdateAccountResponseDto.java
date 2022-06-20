package com.l3azh.management.SpendingManagement.Dtos;

public class UpdateAccountResponseDto {

    private String message;

    public UpdateAccountResponseDto() {
    }

    public UpdateAccountResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

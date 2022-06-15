package com.l3azh.management.SpendingManagement.Dtos;

public class CreateAccountResponseDto {

    private String message;

    public CreateAccountResponseDto() {
    }

    public CreateAccountResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

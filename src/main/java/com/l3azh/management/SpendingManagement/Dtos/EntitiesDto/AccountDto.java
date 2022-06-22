package com.l3azh.management.SpendingManagement.Dtos.EntitiesDto;

import lombok.Data;

import java.util.List;

@Data
public class AccountDto {
    private String email;
    private String firstName;
    private String lastName;
    private String phonenumber;
    private String avatar;
    private List<WalletDto> listWallet;

    public AccountDto() {
    }

    public AccountDto(String email, String firstName, String lastName, String phonenumber, String avatar, List<WalletDto> listWallet) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phonenumber = phonenumber;
        this.avatar = avatar;
        this.listWallet = listWallet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<WalletDto> getListWallet() {
        return listWallet;
    }

    public void setListWallet(List<WalletDto> listWallet) {
        this.listWallet = listWallet;
    }
}

package com.l3azh.management.SpendingManagement.Dtos;

public class UpdateAccountRequestDto {

    private String firstName;
    private String lastName;
    private String phonenumber;
    private String avatar;

    public UpdateAccountRequestDto() {
    }

    public UpdateAccountRequestDto(String firstName, String lastName, String phonenumber, String avatar) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phonenumber = phonenumber;
        this.avatar = avatar;
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
}

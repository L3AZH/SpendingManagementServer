package com.l3azh.management.SpendingManagement.Dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CreateAccountRequestDto {

    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+" +
            "(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+" +
            "(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "Invalid email !")
    @NotEmpty(message = "Email is empty !")
    @NotBlank(message = "Email is blank")
    private String email;
    @NotEmpty(message = "Password is empty !")
    @NotBlank(message = "Password is blank")
    private String password;
    @NotEmpty(message = "First name is empty !")
    @NotBlank(message = "First is blank")
    private String firstName;
    @NotEmpty(message = "Last name is empty !")
    @NotBlank(message = "Last name is blank")
    private String lastName;
    @Pattern(regexp = "^\\d{10}$", message = "Invalid phonenumber !")
    @NotEmpty(message = "Phonenumber is empty !")
    @NotBlank(message = "Phonenumber is blank")
    private String phonenumber;
    private String avatar;

    public CreateAccountRequestDto(String email, String password, String firstName, String lastName, String phonenumber, String avatar) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phonenumber = phonenumber;
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

package com.l3azh.management.SpendingManagement.Entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Account")
public class AccountEntity {

    @Id
    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Phonenumber")
    private String phonenumber;

    @Lob
    @Column(name = "AvatarPic", columnDefinition = "BLOB")
    private byte[] avatarPic;

    @OneToMany(mappedBy = "account")
    private List<WalletEntity> listWallet;

    public AccountEntity(){};

    public AccountEntity(String email, String password, String firstName, String lastName, String phonenumber) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phonenumber = phonenumber;
    }

    public AccountEntity(String email, String password, String firstName, String lastName, String phonenumber, byte[] avatarPic) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phonenumber = phonenumber;
        this.avatarPic = avatarPic;
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

    public byte[] getAvatarPic() {
        return avatarPic;
    }

    public void setAvatarPic(byte[] avatarPic) {
        this.avatarPic = avatarPic;
    }

    public List<WalletEntity> getListWallet() {
        return listWallet;
    }

    public void setListWallet(List<WalletEntity> listWallet) {
        this.listWallet = listWallet;
    }
}

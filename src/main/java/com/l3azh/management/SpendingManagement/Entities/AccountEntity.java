package com.l3azh.management.SpendingManagement.Entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Account")
@Data
@Builder
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

}

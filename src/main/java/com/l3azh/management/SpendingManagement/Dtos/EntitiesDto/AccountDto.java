package com.l3azh.management.SpendingManagement.Dtos.EntitiesDto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AccountDto {
    private String email;
    private String firstName;
    private String lastName;
    private String phonenumber;
    private String avatar;
    private List<WalletDto> listWallet;
}

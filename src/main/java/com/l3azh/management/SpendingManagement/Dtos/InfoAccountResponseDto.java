package com.l3azh.management.SpendingManagement.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class InfoAccountResponseDto {

    private String email;
    private String firstName;
    private String lastName;
    private String phonenumber;
    private String avatar;
}

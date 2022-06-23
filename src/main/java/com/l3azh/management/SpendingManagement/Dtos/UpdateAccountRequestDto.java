package com.l3azh.management.SpendingManagement.Dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateAccountRequestDto {
    private String firstName;
    private String lastName;
    private String phonenumber;
    private String avatar;
}

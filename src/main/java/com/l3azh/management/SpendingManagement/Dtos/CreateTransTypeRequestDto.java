package com.l3azh.management.SpendingManagement.Dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateTransTypeRequestDto {
    private String name;
    private String description;
}

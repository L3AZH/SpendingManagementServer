package com.l3azh.management.SpendingManagement.Dtos;

import com.l3azh.management.SpendingManagement.Utils.AppUtils;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseDto {
    private int code;
    private boolean flag;
    private String errorMessage;
    private String timeStamp;
}

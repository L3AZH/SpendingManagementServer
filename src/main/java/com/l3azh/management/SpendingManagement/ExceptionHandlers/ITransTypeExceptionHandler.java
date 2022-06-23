package com.l3azh.management.SpendingManagement.ExceptionHandlers;

import com.l3azh.management.SpendingManagement.Dtos.ErrorResponseDto;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneTransTypeFoundWithUUIDException;
import org.springframework.http.ResponseEntity;

public interface ITransTypeExceptionHandler {
    ResponseEntity<ErrorResponseDto> handleNoneTransTypeFoundWithUUIDException(NoneTransTypeFoundWithUUIDException e);
}

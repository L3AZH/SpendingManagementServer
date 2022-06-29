package com.l3azh.management.SpendingManagement.Controllers;

import com.l3azh.management.SpendingManagement.DAOS.ITransTypeDao;
import com.l3azh.management.SpendingManagement.Dtos.*;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneTransTypeFoundWithUUIDException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.TransTypeWithNameAlreadyExistInDbException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/transtype")
@RequiredArgsConstructor
public class TransTypeController {

    private final ITransTypeDao iTransTypeDao;

    @PostMapping(value = "/create-trans-type")
    public ResponseEntity<BaseResponseDto<CreateTransTypeResponseDto>> createNewTransType(
            @Valid @RequestBody CreateTransTypeRequestDto requestDto
    ) throws TransTypeWithNameAlreadyExistInDbException {
        BaseResponseDto<CreateTransTypeResponseDto> responseDto = iTransTypeDao.createNewTransType(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping(value = "/update-trans-type")
    public ResponseEntity<BaseResponseDto<UpdateTransTypeResponseDto>> updateTransType(
            @RequestParam String uuidTransType,
            @Valid @RequestBody UpdateTransTypeRequestDto requestDto
    ) throws NoneTransTypeFoundWithUUIDException, TransTypeWithNameAlreadyExistInDbException {
        BaseResponseDto<UpdateTransTypeResponseDto> responseDto = iTransTypeDao.updateTransType(uuidTransType, requestDto);
        return ResponseEntity.ok(responseDto);
    }

}

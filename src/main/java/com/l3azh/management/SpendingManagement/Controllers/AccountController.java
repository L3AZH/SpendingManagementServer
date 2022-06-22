package com.l3azh.management.SpendingManagement.Controllers;

import com.l3azh.management.SpendingManagement.DAOS.IAccountDao;
import com.l3azh.management.SpendingManagement.Dtos.BaseResponseDto;
import com.l3azh.management.SpendingManagement.Dtos.InfoAccountResponseDto;
import com.l3azh.management.SpendingManagement.Dtos.UpdateAccountRequestDto;
import com.l3azh.management.SpendingManagement.Dtos.UpdateAccountResponseDto;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.AccountWithEmailNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    IAccountDao accountDao;

    @GetMapping(value = "/info")
    public ResponseEntity<BaseResponseDto<InfoAccountResponseDto>> getInfo(
            @RequestParam String email) throws AccountWithEmailNotFoundException {
        BaseResponseDto<InfoAccountResponseDto> responseDto = accountDao.getAccountInfo(email);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping(value = "/update-info")
    public ResponseEntity<BaseResponseDto<UpdateAccountResponseDto>> updateAccountInfo(
            @RequestParam String email,
            @Valid @RequestBody UpdateAccountRequestDto requestDto) throws AccountWithEmailNotFoundException {
        BaseResponseDto<UpdateAccountResponseDto> responseDto = accountDao.updateAccountInfo(email, requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}

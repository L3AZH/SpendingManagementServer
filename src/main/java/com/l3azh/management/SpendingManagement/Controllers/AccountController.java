package com.l3azh.management.SpendingManagement.Controllers;

import com.l3azh.management.SpendingManagement.Dtos.BaseResponseDto;
import com.l3azh.management.SpendingManagement.Dtos.InfoAccountResponseDto;
import com.l3azh.management.SpendingManagement.Dtos.UpdateAccountRequestDto;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.AccountWithEmailNotFoundException;
import com.l3azh.management.SpendingManagement.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping(value = "/info")
    public ResponseEntity<BaseResponseDto<InfoAccountResponseDto>> getInfo(@RequestParam String email) throws AccountWithEmailNotFoundException {
        BaseResponseDto<InfoAccountResponseDto> responseDto = accountService.getAccountInfo(email);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping(value = "/update-info")
    public ResponseEntity<BaseResponseDto<String>> updateAccountInfo(@Valid @RequestBody UpdateAccountRequestDto requestDto) throws AccountWithEmailNotFoundException{

    }

}

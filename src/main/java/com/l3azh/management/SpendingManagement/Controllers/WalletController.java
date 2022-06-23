package com.l3azh.management.SpendingManagement.Controllers;

import com.l3azh.management.SpendingManagement.DAOS.IWalletDao;
import com.l3azh.management.SpendingManagement.Dtos.*;
import com.l3azh.management.SpendingManagement.Dtos.EntitiesDto.WalletDto;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.AccountWithEmailNotFoundException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.NoneWalletFoundWithEmailException;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.WalletWithNameAlreadyExistInDb;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/wallet")
@RequiredArgsConstructor
public class WalletController {

    private final IWalletDao iWalletDao;

    @PostMapping("/new-wallet")
    public ResponseEntity<BaseResponseDto<CreateWalletResponseDto>> createNewWallet(
            @RequestParam String email,
            @Valid @RequestBody CreateWalletRequestDto requestDto)
            throws WalletWithNameAlreadyExistInDb, AccountWithEmailNotFoundException {
        BaseResponseDto<CreateWalletResponseDto> responseDto = iWalletDao.createNewWallet(email, requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/update-wallet")
    public ResponseEntity<BaseResponseDto<UpdateWalletResponseDto>> updateWallet(
            @RequestParam String email,
            @Valid @RequestBody UpdateWalletRequestDto requestDto)
            throws WalletWithNameAlreadyExistInDb, AccountWithEmailNotFoundException {
        BaseResponseDto<UpdateWalletResponseDto> responseDto = iWalletDao.updateWallet(email, requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/list-wallet")
    public ResponseEntity<BaseResponseDto<List<WalletDto>>> getListWallet(
            @RequestParam String email)
            throws AccountWithEmailNotFoundException, NoneWalletFoundWithEmailException {
        BaseResponseDto<List<WalletDto>> responseDto = iWalletDao.getListWalletOfAccount(email);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}

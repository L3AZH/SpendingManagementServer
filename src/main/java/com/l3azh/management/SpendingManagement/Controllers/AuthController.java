package com.l3azh.management.SpendingManagement.Controllers;

import com.l3azh.management.SpendingManagement.Dtos.*;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.AccountAlreadyExistException;
import com.l3azh.management.SpendingManagement.Services.AccountService;
import com.l3azh.management.SpendingManagement.Utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    AccountService accountService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping(value = "/login")
    public ResponseEntity<BaseResponseDto<LoginResponseDto>> login(@Valid @RequestBody LoginRequestDto requestDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                requestDto.getEmail(), requestDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.generateJwToken(authentication);
        BaseResponseDto<LoginResponseDto> responseDto =
                new BaseResponseDto<>(HttpStatus.OK.value(), true, new LoginResponseDto(jwt));
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<BaseResponseDto<CreateAccountResponseDto>> createNewAccount(
            @Valid @RequestBody CreateAccountRequestDto requestDto) throws AccountAlreadyExistException {
        BaseResponseDto<CreateAccountResponseDto> response = accountService.createNewAccount(requestDto);
        return new ResponseEntity<BaseResponseDto<CreateAccountResponseDto>>(response, HttpStatus.OK);
    }
}

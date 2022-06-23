package com.l3azh.management.SpendingManagement.Controllers;

import com.l3azh.management.SpendingManagement.DAOS.IAccountDao;
import com.l3azh.management.SpendingManagement.Dtos.*;
import com.l3azh.management.SpendingManagement.ExceptionHandlers.Expceptions.AccountAlreadyExistException;
import com.l3azh.management.SpendingManagement.Utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtUtil jwtUtil;

    private final IAccountDao accountDao;

    private final AuthenticationManager authenticationManager;

    @PostMapping(value = "/login")
    public ResponseEntity<BaseResponseDto<LoginResponseDto>> login(@Valid @RequestBody LoginRequestDto requestDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                requestDto.getEmail(), requestDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.generateJwToken(authentication);
        return new ResponseEntity<>(BaseResponseDto.<LoginResponseDto>builder()
                .code(HttpStatus.OK.value())
                .flag(true)
                .data(LoginResponseDto.builder().token(jwt).build()).build(), HttpStatus.OK);
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<BaseResponseDto<CreateAccountResponseDto>> createNewAccount(
            @Valid @RequestBody CreateAccountRequestDto requestDto) throws AccountAlreadyExistException {
        BaseResponseDto<CreateAccountResponseDto> response = accountDao.createNewAccount(requestDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

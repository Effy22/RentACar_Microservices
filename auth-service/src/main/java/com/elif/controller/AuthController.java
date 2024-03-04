package com.elif.controller;

import com.elif.dto.request.LoginRequestDto;
import com.elif.dto.request.RegisterRequestDto;
import com.elif.entity.Auth;
import com.elif.exception.AuthServiceException;
import com.elif.exception.ErrorType;
import com.elif.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.elif.constants.RestApiUrls.*;

@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;


    @PostMapping(REGISTER)
    public ResponseEntity<Boolean> register ( @RequestBody @Valid RegisterRequestDto dto){
        return ResponseEntity.ok(authService.register(dto));
    }
    @PostMapping(LOGIN)
    public ResponseEntity<String> doLogin ( @RequestBody @Valid LoginRequestDto dto){
        Optional<Auth> auth = authService.doLogin(dto);
        if(auth.isEmpty()){
            throw new AuthServiceException(ErrorType.ERROR_INVALID_LOGIN_PARAMETER);
        }

        return ResponseEntity.ok("Welcome..: " + auth.get().getUsername());
    }



}

package com.elif.service;

import com.elif.dto.request.LoginRequestDto;
import com.elif.dto.request.RegisterRequestDto;
import com.elif.entity.Auth;
import com.elif.exception.AuthServiceException;
import com.elif.exception.ErrorType;
import com.elif.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;


    public Boolean register(RegisterRequestDto dto){
        Optional<Auth> optionalAuth1 = authRepository.findOptionalByUsername(dto.getUsername());
        Optional<Auth> optionalAuth2 = authRepository.findOptionalByEmail(dto.getEmail());
        if(optionalAuth1.isEmpty() && optionalAuth2.isEmpty()){
            Auth auth = Auth.builder()
                    .username(dto.getUsername())
                    .email(dto.getEmail())
                    .password(dto.getPassword())
                    .createAt(System.currentTimeMillis())
                    .updateAt(System.currentTimeMillis())
                    .isActive(true)
                    .build();
            authRepository.save(auth);
            return true;
        }else{
            throw new AuthServiceException(ErrorType.ERROR_USER_ALLREADY_EXISTS);
        }

    }

    public Optional<Auth> doLogin (LoginRequestDto dto){
        Optional<Auth> auth = authRepository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if(auth.isPresent()){
            return auth;
        }else{
            throw new AuthServiceException(ErrorType.ERROR_INVALID_LOGIN_PARAMETER);
        }
    }


}

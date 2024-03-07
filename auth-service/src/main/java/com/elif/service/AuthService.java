package com.elif.service;

import com.elif.dto.request.CreateUserRequestDto;
import com.elif.dto.request.LoginRequestDto;
import com.elif.dto.request.RegisterRequestDto;
import com.elif.entity.Auth;
import com.elif.exception.AuthServiceException;
import com.elif.exception.ErrorType;
import com.elif.manager.UserProfileManager;
import com.elif.rabbitmq.model.UserModel;
import com.elif.rabbitmq.producer.UserProducer;
import com.elif.repository.AuthRepository;
import com.elif.utility.JwtTokenManager;
import com.elif.utility.enums.EStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;
   // private final UserProfileManager userProfileManager; //Rabbit yerine OpenFeign kullanılacak ise.
    private final JwtTokenManager jwtTokenManager;
    private final UserProducer userProducer;

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
//            Eğer userProfileManager kullanılacak ise aşağıdaki metot;
//            userProfileManager.createUser(CreateUserRequestDto.builder()
//                            .authId(auth.getId())
//                            .username(auth.getUsername())
//                            .email(auth.getEmail())
//                    .build());
            userProducer.sendMessage(UserModel.builder()
                            .authId(auth.getId())
                            .email(auth.getEmail())
                            .username(auth.getUsername())
                            .password(auth.getPassword())
                    .build());
            return true;
        }else{
            throw new AuthServiceException(ErrorType.ERROR_USER_ALLREADY_EXISTS);
        }

    }



    public String login(LoginRequestDto dto) {
        Optional<Auth>authOptional = authRepository.findOptionalByUsernameAndPassword(dto.getUsername(),dto.getPassword());
        if(authOptional.isEmpty()){
            throw new AuthServiceException(ErrorType.LOGIN_ERROR);
        }
        if(authOptional.get().getStatus().equals(EStatus.ACTIVE)){
            return jwtTokenManager.createToken(authOptional.get().getId(),authOptional.get().getRole())
                    .orElseThrow(() -> {throw new AuthServiceException(ErrorType.TOKEN_NOT_CREATED);});
        } else {
            throw new AuthServiceException(ErrorType.ACCOUNT_NOT_ACTIVE);
        }
    }
}

package com.elif.service;

import com.elif.domain.User;
import com.elif.dto.request.CreateUserRequestDto;
import com.elif.dto.response.UserResponseDto;
import com.elif.exception.ErrorType;
import com.elif.exception.UserServiceException;
import com.elif.mapper.UserMapper;
import com.elif.repository.UserRepository;
import com.elif.utility.JwtTokenManager;
import com.elif.utility.enums.EStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JwtTokenManager jwtTokenManager;

    public Boolean createUser(CreateUserRequestDto dto){
       try{
           userRepository.save(UserMapper.INSTANCE.fromSaveRequestToUser(dto));
           return true;
       }catch (Exception e){
           throw new UserServiceException(ErrorType.ERROR_USER_CANNOT_CREATED);
       }
    }

    public Boolean activateStatus(Long authId) {
       Optional<User> optionalUser = userRepository.findByAuthId(authId);
       if(optionalUser.isPresent()){
           optionalUser.get().setStatus(EStatus.ACTIVE);
           optionalUser.get().setUpdateDate(System.currentTimeMillis());
           userRepository.save(optionalUser.get());
           return true;
       }else{
           throw new UserServiceException(ErrorType.USER_NOT_FOUND);
       }

    }


    public Double getUserBalance(String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isPresent()){
            return optionalUser.get().getBalance();
        }else{
            throw new UserServiceException(ErrorType.USER_NOT_FOUND);
        }
    }

    public User findUserById(String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }else{
            throw new UserServiceException(ErrorType.USER_NOT_FOUND);
        }
    }


    public UserResponseDto findUserByToken(String token) {
        Optional<Long> authId = jwtTokenManager.getIdFromToken(token);
        if (authId.isPresent()){
            User user = userRepository.findOptionalByAuthId(authId.get()).get();
            return UserMapper.INSTANCE.fromUserToUserResponseDto(user);
        }
        throw new UserServiceException(ErrorType.USER_NOT_FOUND);
    }
}

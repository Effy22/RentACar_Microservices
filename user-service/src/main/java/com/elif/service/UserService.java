package com.elif.service;

import com.elif.domain.User;
import com.elif.dto.request.UserSaveRequestDto;
import com.elif.exception.ErrorType;
import com.elif.exception.UserServiceException;
import com.elif.mapper.UserMapper;
import com.elif.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Boolean createUser(UserSaveRequestDto dto){
       try{
           userRepository.save(UserMapper.INSTANCE.fromSaveRequestToUser(dto));
           return true;
       }catch (Exception e){
           throw new UserServiceException(ErrorType.ERROR_USER_CANNOT_CREATED);
       }
    }

    public Boolean activateStatus(Long authId) {
       // TODO: Tüm metotlar yazılacak.
        return true;
    }

}

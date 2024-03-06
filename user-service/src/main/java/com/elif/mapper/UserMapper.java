package com.elif.mapper;

import com.elif.domain.User;
import com.elif.dto.request.CreateUserRequestDto;
import com.elif.dto.response.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User fromSaveRequestToUser(CreateUserRequestDto dto);

    UserResponseDto fromUserToUserResponseDto(User user);

}

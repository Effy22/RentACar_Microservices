package com.elif.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    String id;
    Long authId;
    String username;
    String email;
    String password;
    String name;
    String surname;
    Double balance;
}

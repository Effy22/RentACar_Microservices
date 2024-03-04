package com.elif.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {

    @Size(min = 3, max = 64)
    @NotNull
    String username;
    @Size(min = 3, max = 32)
    @NotNull
    String password;
    @Email
    @NotNull
    String email;
}

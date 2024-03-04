package com.elif.entity;

import com.elif.utility.enums.ERole;
import com.elif.utility.enums.EStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_auth")
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    @Size(min = 8, max = 30, message = "Kullanıcı adı en az 8, en fazla 30 karakter olmalıdır.")
    String username;
    @Size(min = 8, max = 30, message = "Şifre en az 8, en fazla 30 karakter olmalıdır.")
    String password;
    String email;
    Long createAt;
    Long updateAt;
    Boolean isActive;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    ERole role = ERole.USER;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    EStatus status = EStatus.PENDING;
}

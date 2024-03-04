package com.elif.repository;

import com.elif.entity.Auth;
import com.elif.utility.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth,Long> {

    Optional<Auth> findOptionalByUsernameAndPassword(String username, String password);

    List<Auth> findAllByRole(ERole role);

    Optional<Auth> findOptionalByUsername(String username);
    Optional<Auth> findOptionalByEmail(String email);

}

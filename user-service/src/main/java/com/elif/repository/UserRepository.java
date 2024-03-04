package com.elif.repository;

import com.elif.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
    Page<User> findByEmail(String email, Pageable pageable); //All returns should be in page format
    Optional<User> findByAuthId(Long authId);

    List<User>  findByAddressContaining (String adress);

    Page<User> findBySurname(String surname, Pageable pageable);
}

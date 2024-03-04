package com.elif.repository;

import com.elif.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {
    Page<User> findByEmail(String email, Pageable pageable); //All returns should be in page format
    Page<User> findByAuthId(Long authId);

    List<User>  findByAdressContaining (String adress);

    Page<User> findBySurname(String surname, Pageable pageable);
}

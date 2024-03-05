package com.elif.repository;

import com.elif.entity.Renting;
import com.elif.utility.enums.ELocation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RentingRepository extends MongoRepository<Renting,String> {

    List<Renting> findAllByDropOffLocation(ELocation dropOffLocation);
    List<Renting> findAllByUserId(String userId);
    List<Renting> findAllByEndDate(Date endDate);


}

package com.elif.repository;

import com.elif.entity.Vehicle;
import com.elif.utility.enums.EBrand;
import com.elif.utility.enums.EModel;
import com.elif.utility.enums.EStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle,String> {

    List<Vehicle> findAllByStatus(EStatus status);
    List<Vehicle> findAllByModel(EModel model);
    List<Vehicle> findAllByBrand(EBrand brand);


    Optional<Vehicle> findByModelAndStatus(EModel model, EStatus status);

}

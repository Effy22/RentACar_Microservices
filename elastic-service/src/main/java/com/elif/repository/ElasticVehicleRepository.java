package com.elif.repository;

import com.elif.domain.Vehicle;
import com.elif.utility.enums.EModel;
import com.elif.utility.enums.EStatus;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ElasticVehicleRepository extends ElasticsearchRepository<Vehicle,String> {

    List<Vehicle> findAllByStatus(EStatus eStatus);

    List<Vehicle> findAllByModelAndStatus(EModel model, EStatus eStatus);

}

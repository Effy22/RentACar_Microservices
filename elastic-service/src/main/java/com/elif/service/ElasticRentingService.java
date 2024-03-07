package com.elif.service;

import com.elif.domain.Renting;
import com.elif.repository.ElasticRentingRepository;
import com.elif.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class ElasticRentingService extends ServiceManager<Renting,String>{
    private final ElasticRentingRepository rentingRepository;

    public ElasticRentingService(ElasticRentingRepository rentingRepository) {
        super(rentingRepository);
        this.rentingRepository = rentingRepository;
    }
}

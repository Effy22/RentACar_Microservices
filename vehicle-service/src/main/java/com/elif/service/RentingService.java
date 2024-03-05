package com.elif.service;

import com.elif.entity.Renting;
import com.elif.repository.RentingRepository;
import com.elif.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class RentingService extends ServiceManager<Renting,String> {

    private final RentingRepository rentingRepository;

    public RentingService(RentingRepository rentingRepository) {
        super(rentingRepository);
        this.rentingRepository = rentingRepository;
    }

}

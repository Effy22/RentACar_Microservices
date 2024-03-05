package com.elif.service;

import com.elif.entity.Vehicle;
import com.elif.repository.VehicleRepository;
import com.elif.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class VehicleService extends ServiceManager<Vehicle,String> {
    private final VehicleRepository vehicleRepository;
    public VehicleService(VehicleRepository vehicleRepository) {
        super(vehicleRepository);
        this.vehicleRepository = vehicleRepository;
    }
}

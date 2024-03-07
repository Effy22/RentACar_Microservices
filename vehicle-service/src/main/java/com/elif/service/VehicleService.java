package com.elif.service;

import com.elif.dto.request.VehicleAddRequestDto;
import com.elif.entity.Vehicle;
import com.elif.exception.ErrorType;
import com.elif.exception.VehicleServiceException;
import com.elif.mapper.VehicleMapper;
import com.elif.repository.VehicleRepository;
import com.elif.utility.ServiceManager;
import com.elif.utility.enums.EModel;
import com.elif.utility.enums.EStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService extends ServiceManager<Vehicle,String> {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        super(vehicleRepository);
        this.vehicleRepository = vehicleRepository;
    }

    public Optional<Vehicle> findByModelAndStatus(EModel model, EStatus status) {
        return vehicleRepository.findByModelAndStatus(model, status);
    }

    public Boolean addVehicle(VehicleAddRequestDto dto) {
        Vehicle vehicle = VehicleMapper.INSTANCE.fromVehicleAddRequestDtoToVehicle(dto);
       Optional<Vehicle> optionalVehicle=vehicleRepository.findById(vehicle.getId());
       if(optionalVehicle.isPresent()){
           throw new VehicleServiceException(ErrorType.VEHICLE_ALREADY_EXISTS);
       }else{
           vehicleRepository.save(vehicle);
           return true;
       }


    }

    public List<Vehicle> getAll() {
        List<Vehicle> availableVehicles =vehicleRepository.findAllByStatus(EStatus.AVAILABLE);
        if(availableVehicles.isEmpty()){
            throw new VehicleServiceException(ErrorType.VEHICLE_NOT_FOUND);
        }else{
            return availableVehicles;
        }


    }
}

package com.elif.service;

import com.elif.domain.Vehicle;
import com.elif.dto.VehicleSaveDto;
import com.elif.repository.ElasticVehicleRepository;
import com.elif.utility.ServiceManager;
import com.elif.utility.enums.EModel;
import com.elif.utility.enums.EStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElasticVehicleService extends ServiceManager<Vehicle,String> {
    private final ElasticVehicleRepository elasticVehicleRepository;

    public ElasticVehicleService(ElasticVehicleRepository elasticVehicleRepository) {
        super(elasticVehicleRepository);
        this.elasticVehicleRepository = elasticVehicleRepository;
    }

    public void save(VehicleSaveDto dto){
        Vehicle vehicle= Vehicle.builder()
                .name(dto.name())
                .brand(dto.brand())
                .year(dto.year())
                .model(dto.model())
                .status(EStatus.AVAILABLE)
                .color(dto.color())
                .fuel(dto.fuel())
                .category(dto.category())
                .createDate(System.currentTimeMillis())
                .description(dto.description())
                .kilometers(dto.kilometers())
                .dailyPrice(dto.dailyPrice())
                .build();
        elasticVehicleRepository.save(vehicle);
    }

    public void update(VehicleSaveDto dto){
        Vehicle vehicle= Vehicle.builder()
                .name(dto.name())
                .brand(dto.brand())
                .year(dto.year())
                .model(dto.model())
                .status(EStatus.AVAILABLE)
                .color(dto.color())
                .fuel(dto.fuel())
                .category(dto.category())
                .updateDate(System.currentTimeMillis())
                .description(dto.description())
                .kilometers(dto.kilometers())
                .dailyPrice(dto.dailyPrice())
                .build();
        elasticVehicleRepository.save(vehicle);
    }

    public List<Vehicle> findAllAvailableVehicles(){
        return elasticVehicleRepository.findAllByStatus(EStatus.AVAILABLE);
    }

    public Iterable<Vehicle> findAllAvailableVehiclesByModel(EModel model) {
        return elasticVehicleRepository.findAllByModelAndStatus(model, EStatus.AVAILABLE);
    }
}

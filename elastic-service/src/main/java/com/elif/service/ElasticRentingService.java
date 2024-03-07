package com.elif.service;

import com.elif.domain.Renting;
import com.elif.domain.Vehicle;
import com.elif.dto.RentingSaveDto;
import com.elif.dto.VehicleSaveDto;
import com.elif.repository.ElasticRentingRepository;
import com.elif.utility.ServiceManager;
import com.elif.utility.enums.EStatus;
import org.springframework.stereotype.Service;

@Service
public class ElasticRentingService extends ServiceManager<Renting,String>{
    private final ElasticRentingRepository rentingRepository;

    public ElasticRentingService(ElasticRentingRepository rentingRepository) {
        super(rentingRepository);
        this.rentingRepository = rentingRepository;
    }

    public void save(RentingSaveDto dto){
        Renting renting= Renting.builder()
                .id(dto.id())
                .userId(dto.userId())
                .price(dto.price())
                .notes(dto.notes())
                .startDate(dto.startDate())
                .pickUpLocation(dto.pickUpLocation())
                .dropOffLocation(dto.dropOffLocation())
                .endDate(dto.endDate())
                .vehicleId(dto.vehicleId())
                .createDate(System.currentTimeMillis())
                .build();
        rentingRepository.save(renting);
    }

    public void update(RentingSaveDto dto){
        Renting renting= Renting.builder()
                .id(dto.id())
                .userId(dto.userId())
                .price(dto.price())
                .notes(dto.notes())
                .startDate(dto.startDate())
                .pickUpLocation(dto.pickUpLocation())
                .dropOffLocation(dto.dropOffLocation())
                .endDate(dto.endDate())
                .vehicleId(dto.vehicleId())
                .updateDate(System.currentTimeMillis())
                .build();
        rentingRepository.save(renting);
    }

    public Iterable<Renting> findAllByUserId(String userId) {
        return rentingRepository.findAllByUserId(userId);
    }
}

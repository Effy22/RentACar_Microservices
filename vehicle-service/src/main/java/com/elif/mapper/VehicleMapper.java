package com.elif.mapper;

import com.elif.dto.request.VehicleAddRequestDto;
import com.elif.dto.request.VehicleSaveDto;
import com.elif.entity.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface VehicleMapper {

    VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);
    Vehicle fromVehicleAddRequestDtoToVehicle(VehicleAddRequestDto vehicleAddRequestDto);

    VehicleSaveDto fromVehicleToVehicleSaveDto(Vehicle vehicle);

}

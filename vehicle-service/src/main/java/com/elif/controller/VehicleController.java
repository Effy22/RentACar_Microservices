package com.elif.controller;
import com.elif.dto.request.VehicleAddRequestDto;
import com.elif.entity.Vehicle;
import com.elif.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.elif.constant.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(VEHICLE)
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping(ADD)
    public ResponseEntity<Boolean> addVehicle(@RequestBody VehicleAddRequestDto dto){
        return ResponseEntity.ok(vehicleService.addVehicle(dto));
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<Vehicle>> getAll(){
        return ResponseEntity.ok(vehicleService.getAll());
    }

}

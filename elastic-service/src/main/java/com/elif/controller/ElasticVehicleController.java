package com.elif.controller;

import com.elif.domain.Vehicle;
import com.elif.dto.VehicleSaveDto;
import com.elif.service.ElasticVehicleService;
import com.elif.utility.enums.EModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.elif.constant.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(VEHICLE)
public class ElasticVehicleController {
    private final ElasticVehicleService elasticVehicleService;


    @PostMapping(CREATE)
    private ResponseEntity<Boolean> save(@RequestBody VehicleSaveDto dto){
        elasticVehicleService.save(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping(UPDATE)
    private  ResponseEntity<Boolean> update(@RequestBody VehicleSaveDto dto){
        elasticVehicleService.update(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<Iterable<Vehicle>> findAll(){
        return ResponseEntity.ok(elasticVehicleService.findAllAvailableVehicles());
    }

    @GetMapping(FIND_BY_MODEL+"/{model}")
    public ResponseEntity<Iterable<Vehicle>> findAllByModel(@PathVariable EModel model){
        return ResponseEntity.ok(elasticVehicleService.findAllAvailableVehiclesByModel(model));
    }

}

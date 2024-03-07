package com.elif.manager;

import com.elif.dto.request.VehicleSaveDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import static com.elif.constant.RestApiUrls.*;

@FeignClient(name = "elastic-vehicle-service", url = "http://localhost:9200/dev/v1/elastic/vehicle")
public interface ElasticVehicleManager {
    @PostMapping(CREATE)
    ResponseEntity<Boolean> save(@RequestBody VehicleSaveDto dto);


}

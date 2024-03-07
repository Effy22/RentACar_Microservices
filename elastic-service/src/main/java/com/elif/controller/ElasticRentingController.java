package com.elif.controller;

import com.elif.domain.Renting;
import com.elif.dto.RentingSaveDto;
import com.elif.service.ElasticRentingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.elif.constant.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(RENTING)
public class ElasticRentingController {

    private final ElasticRentingService elasticRentingService;

    @PostMapping(CREATE)
    public ResponseEntity<Boolean> save(@RequestBody RentingSaveDto dto){
        elasticRentingService.save(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping(UPDATE)
    public ResponseEntity<Boolean> update(@RequestBody RentingSaveDto dto){
        elasticRentingService.update(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<Iterable<Renting>> findAll(){
        return ResponseEntity.ok(elasticRentingService.findAll());
    }

    @GetMapping(FIND_ALL_BY_USER_ID)
    public ResponseEntity<Iterable<Renting>> findAllByUserId(String userId){
        return ResponseEntity.ok(elasticRentingService.findAllByUserId(userId));
    }
}

package com.elif.controller;


import com.elif.dto.request.CancellationRequestDto;
import com.elif.dto.request.RequestRentingDto;
import com.elif.service.RentingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.elif.constant.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(RENTING)
public class RentingController {

    private final RentingService rentingService;


    @PostMapping(REQUEST_RENTING)
    public ResponseEntity<String> requestRenting(@RequestBody RequestRentingDto dto) {
        return ResponseEntity.ok(rentingService.requestRenting(dto));
    }

    @PostMapping(CANCEL_RENTING)
    public ResponseEntity<String> cancelRenting(@RequestBody CancellationRequestDto dto) {
        return ResponseEntity.ok(rentingService.cancelRenting(dto));
    }


}

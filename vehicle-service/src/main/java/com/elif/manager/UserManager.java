package com.elif.manager;

import com.elif.dto.response.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import static com.elif.constant.RestApiUrls.*;

@FeignClient(url = "localhost:9094/dev/v1/user", name = "UserManager")
public interface UserManager {

    @GetMapping(GET_BALANCE+"/{userId}")
    ResponseEntity<Double> getUserBalance(@PathVariable String userId);

    @GetMapping(FIND_BY_TOKEN)
    public ResponseEntity<UserResponseDto> findUserByToken(@RequestParam String token);


}

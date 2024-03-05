package com.elif.manager;

import com.elif.dto.request.CreateUserRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.elif.constants.RestApiUrls.*;

@FeignClient(url = "http://localhost:9094/dev/v1/user", name = "UserProfileManager")
public interface UserProfileManager {
    @PostMapping(CREATE)
    public ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequestDto dto);
}

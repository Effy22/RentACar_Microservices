package com.elif.controller;

import com.elif.domain.User;
import com.elif.dto.request.CreateUserRequestDto;
import com.elif.dto.response.UserResponseDto;
import com.elif.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.elif.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(USER)
public class UserController {
    private final UserService userService;
    @PostMapping(CREATE)
    public ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequestDto dto){
        return ResponseEntity.ok(userService.createUser(dto));
    }

    @GetMapping(ACTIVATE_STATUS+"/{authId}")
    public ResponseEntity<Boolean> activateStatus(@PathVariable Long authId){
        return ResponseEntity.ok(userService.activateStatus(authId));
    }

    @GetMapping(GET_BALANCE+"/{userId}")
    public ResponseEntity<Double> getUserBalance(@PathVariable String userId){
        return ResponseEntity.ok(userService.getUserBalance(userId));
    }

    @GetMapping(FIND_BY_TOKEN)
    public ResponseEntity<UserResponseDto> findUserByToken(@RequestParam String token) {
        return ResponseEntity.ok(userService.findUserByToken(token));
    }






}

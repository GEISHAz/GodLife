package com.glcom.GodLife.user.controller;


import com.glcom.GodLife.user.common.request.RegisterRequest;
import com.glcom.GodLife.user.common.response.ApiResponse;
import com.glcom.GodLife.user.dto.UserDto;
import com.glcom.GodLife.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/hello")
    public ApiResponse<String> checkResponse(){
        return ApiResponse.success("Hi, this is GodLifeServer.");
    }

    @PostMapping("/register")
    public ApiResponse<UserDto> registerUser(@RequestBody RegisterRequest request){
        return ApiResponse.success("회원가입 완료",userService.register(request));
    }

}

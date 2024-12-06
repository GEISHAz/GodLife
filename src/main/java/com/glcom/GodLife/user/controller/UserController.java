package com.glcom.GodLife.user.controller;


import com.glcom.GodLife.user.common.request.CheckNickNameRequest;
import com.glcom.GodLife.user.common.request.CheckEmailRequest;
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

    @GetMapping("/checkEmail")
    public ApiResponse<String> isDuplicatedEmail(@RequestBody CheckEmailRequest checkRequest){
        return ApiResponse.success(userService.checkEmail(checkRequest));
    }

    @GetMapping("/checkNickName")
    public ApiResponse<String> isDuplicatedNickName(@RequestBody CheckNickNameRequest checkRequest){
        return ApiResponse.success(userService.checkNickName(checkRequest));
    }

}

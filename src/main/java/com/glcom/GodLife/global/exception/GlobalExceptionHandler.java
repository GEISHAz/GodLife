package com.glcom.GodLife.global.exception;

import com.glcom.GodLife.user.common.exception.CustomException;
import com.glcom.GodLife.user.common.response.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ApiResponse<String> handleIllegalArgumentException(CustomException ex) {
        return ApiResponse.error(
                ex.getStatus(),
                "잘못된 요청: " + ex.getMessage());
    }
}

package com.glcom.GodLife.user.common.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse<T> {

    private int status;        // 상태 코드 (예: 200, 400, 500 등)
    private String message;    // 응답 메시지 (성공 또는 에러 메시지)
    private T data;            // 실제 데이터 (제네릭으로 다양한 타입 처리 가능)

    // 성공 응답을 위한 정적 메서드
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, "Success", data);
    }

    // 성공 응답을 위한 정적 메서드
    public static <T> ApiResponse<T> success(String message,T data) {
        return new ApiResponse<>(200, message, data);
    }

    // 에러 응답을 위한 정적 메서드
    public static <T> ApiResponse<T> error(HttpStatus status, String message) {
        return new ApiResponse<>(status.value(), message, null);
    }
}
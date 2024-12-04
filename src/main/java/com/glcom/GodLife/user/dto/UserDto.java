package com.glcom.GodLife.user.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserDto(String id,String nickName, LocalDateTime createdDate) {
}

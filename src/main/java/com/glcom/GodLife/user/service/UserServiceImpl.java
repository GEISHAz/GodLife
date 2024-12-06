package com.glcom.GodLife.user.service;

import com.glcom.GodLife.user.common.exception.CustomException;
import com.glcom.GodLife.user.common.request.CheckEmailRequest;
import com.glcom.GodLife.user.common.request.CheckNickNameRequest;
import com.glcom.GodLife.user.common.request.RegisterRequest;
import com.glcom.GodLife.user.dto.UserDto;
import com.glcom.GodLife.user.entity.User;
import com.glcom.GodLife.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto register(RegisterRequest request) {

        if (userRepository.existsByUserEmail(request.getUserEmail()))
            throw new CustomException("이미 존재하는 이메일 입니다", HttpStatus.CONFLICT);

        if (userRepository.existsByNickName(request.getNickName()))
            throw new CustomException("이미 존재하는 닉네임 입니다.", HttpStatus.CONFLICT);

        User user = userRepository.save(User
                .builder()
                    .userId(request.getUserId())
                    .userPwd(request.getUserPwd())
                    .userName(request.getUserName())
                    .nickName(request.getNickName())
                    .userEmail(request.getUserEmail())
                    .createdDate(LocalDateTime.now())
                    .lastModifiedDate(LocalDateTime.now())
                .build());

        return UserDto
                .builder()
                    .id(user.getUserId())
                    .nickName(user.getNickName())
                    .createdDate(user.getCreatedDate())
                .build();
    }

    @Override
    public String checkEmail(CheckEmailRequest checkRequest) {
        if (userRepository.existsByUserEmail(checkRequest.getUserEmail()))
            throw new CustomException("이미 존재하는 이메일 입니다", HttpStatus.CONFLICT);
        return "사용가능한 이메일 입니다.";
    }

    @Override
    public String checkNickName(CheckNickNameRequest checkRequest) {
        if (userRepository.existsByNickName(checkRequest.getNickName()))
            throw new CustomException("이미 존재하는 닉네임 입니다.", HttpStatus.CONFLICT);
        return "사용가능한 닉네임 입니다.";
    }
}

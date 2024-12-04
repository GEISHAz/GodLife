package com.glcom.GodLife.user.service;

import com.glcom.GodLife.user.common.request.RegisterRequest;
import com.glcom.GodLife.user.dto.UserDto;

public interface UserService {

    UserDto register(RegisterRequest request);

}

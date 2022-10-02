package com.memories.api.service.users;

import com.memories.api.domain.common.Platform;
import com.memories.api.response.UserResponse;

public interface UserService {

    UserResponse signUp(String nickName, String email, String password, Platform platform);
}

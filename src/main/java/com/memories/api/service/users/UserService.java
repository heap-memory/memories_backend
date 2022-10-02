package com.memories.api.service.users;

import com.memories.api.domain.common.Platform;

public interface UserService {

    void signUp(String nickName, String email, String password, Platform platform);
}

package com.memories.api.request;

import com.memories.api.domain.common.Platform;
import lombok.Getter;

@Getter
public class UserRequest {
    private String nickName;
    private String email;
    private String password;
    private Platform platform;
}

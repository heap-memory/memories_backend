package com.memories.api.response;

import com.memories.api.domain.common.Platform;
import com.memories.api.domain.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponse {
    private String nickName;
    private String email;
    private Platform platform;

    @Builder
    public UserResponse(String nickName, String email, Platform platform) {
        this.nickName = nickName;
        this.email = email;
        this.platform = platform;
    }

    public static UserResponse from(User user) {
        return UserResponse.builder()
                .nickName(user.getNickName())
                .email(user.getEmail())
                .platform(user.getPlatform())
                .build();
    }

}

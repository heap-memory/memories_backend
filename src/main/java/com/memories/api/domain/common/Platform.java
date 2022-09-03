package com.memories.api.domain.common;

import lombok.Getter;

@Getter
public enum Platform {
    NONE("none"),
    EMAIL("email"),
    KAKAO("kakao"),
    NAVER("naver"),
    GOOGLE("google"),
    APPLE("apple"),
    FACEBOOK("facebook"),
    ;

    private String value;

    Platform(String value) {
        this.value = value;
    }
}

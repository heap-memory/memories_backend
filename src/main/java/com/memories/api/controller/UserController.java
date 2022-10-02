package com.memories.api.controller;

import com.memories.api.domain.core.ApiResult;
import com.memories.api.request.UserRequest;
import com.memories.api.service.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping
    public ApiResult<Void> signUp(@RequestBody UserRequest userRequest) {
        userService.signUp(userRequest.getNickName(), userRequest.getEmail(),
                userRequest.getPassword(), userRequest.getPlatform());
        return ApiResult.ok();
    }
}

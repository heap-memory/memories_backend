package com.memories.api.service.users.impl;

import com.memories.api.domain.common.Platform;
import com.memories.api.domain.core.ApiException;
import com.memories.api.domain.core.Code;
import com.memories.api.domain.user.User;
import com.memories.api.repository.user.UserRepository;
import com.memories.api.service.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Transactional
    @Override
    public void signUp(String nickName, String email, String password, Platform platform) {
        User findUser = userRepository.findByEmail(email);
        if (findUser != null) {
            throw new ApiException(Code.NOT_FOUND_USER_INFO);
        }

        User user = User.builder()
                .nickName(nickName)
                .email(email)
                .password(password)
                .platform(platform)
                .build();

        user.encryptPassword(bCryptPasswordEncoder);
        userRepository.save(user);
    }
}

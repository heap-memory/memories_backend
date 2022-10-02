package com.memories.api.service.users;

import com.memories.api.domain.common.Platform;
import com.memories.api.domain.core.ApiException;
import com.memories.api.domain.core.Code;
import com.memories.api.domain.user.User;
import com.memories.api.repository.user.UserRepository;
import com.memories.api.response.UserResponse;
import com.memories.api.service.users.impl.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Mock
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @DisplayName("회원가입이 정상적으로 진행된다.")
    @Test
    void signUp() {
        String nickName = "디벨로피아";
        String email = "developiaa@gmail.com";
        String password = "password";
        Platform platform = Platform.NONE;

        UserResponse userResponse = UserResponse.builder()
                .nickName(nickName)
                .email(email)
                .platform(platform)
                .build();


        given(userRepository.findByEmail(email))
                .willReturn(null);


        assertThat(userService.signUp(nickName, email, password, platform).getEmail())
                .isEqualTo(userResponse.getEmail());

    }

    @DisplayName("이미 가입된 이메일일 경우 회원가입은 불가능하다.")
    @Test
    void signUp_fail() {
        String nickName = "디벨로피아";
        String email = "developiaa@gmail.com";
        String password = "password";
        Platform platform = Platform.NONE;

        User mockUser = User.builder()
                .nickName(nickName)
                .email(email)
                .password(password)
                .platform(platform)
                .build();

        given(userRepository.findByEmail(email)).willReturn(mockUser);

        assertThatThrownBy(() -> userService.signUp(nickName, email, password, platform))
                .isInstanceOf(ApiException.class)
                .hasMessage(Code.NOT_FOUND_USER_INFO.getMessage());
    }

}

package com.memories.api.domain.user;

import com.memories.api.domain.common.BaseTime;
import com.memories.api.domain.common.Platform;
import com.memories.api.domain.memory.Memory;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "users")
public class User extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "platform")
    private Platform platform;

    @OneToMany(mappedBy = "user")
    private List<Memory> memories;

    @Builder
    public User(String nickName, String email, String password, Platform platform) {
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.platform = platform;
    }

    public void encryptPassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }

    public boolean checkPassword(String plainPassword, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(plainPassword, this.password);
    }
}

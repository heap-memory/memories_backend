package com.memories.api.domain.user;

import com.memories.api.domain.common.BaseTime;
import com.memories.api.domain.common.Platform;
import com.memories.api.domain.memory.Memory;

import javax.persistence.*;
import java.util.List;

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

    @Column(name="password")
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "platform")
    private Platform platform;

    @OneToMany(mappedBy ="user")
    private List<Memory> memories;



}

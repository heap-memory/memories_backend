package com.memories.api.domain.memory;

import com.memories.api.domain.common.BaseTime;
import com.memories.api.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "memories")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Memory extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "author")
    private String author;

    @Column(name = "content")
    private String content;

    @Builder
    public Memory(String author, String content) {
        this.author = author;
        this.content = content;
    }

}

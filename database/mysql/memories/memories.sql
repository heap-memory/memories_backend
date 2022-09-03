use memories;
CREATE TABLE memory
(
    id         BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    user_id    BIGINT(20)    NOT NULL comment 'users.id',
    author     VARCHAR(50)   NOT NULL comment '말한 사람',
    content    VARCHAR(2000) NOT NULL comment '내용',
    created_at DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '수정일'
);

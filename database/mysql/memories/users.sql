use memories;
CREATE TABLE users
(
    id         BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    nickName   VARCHAR(20)  NOT NULL comment '별명',
    email      VARCHAR(50) NOT NULL comment '이메일',
    password   VARCHAR(100) NOT NULL comment '비밀번호',
    platform   VARCHAR(20)  NOT NULL comment '가입 경로',
    created_at DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '수정일'
);

-- 유저 테이블
CREATE TABLE USER_MST (
    USER_NO number not null
    ,USER_ID varchar2(50) not null
    ,USER_NAME varchar2(25) not null
    ,USER_GENDER varchar2(1)
    ,PHONE_ST varchar2(3)
    ,PHONE_MD varchar2(4)
    ,PHONE_ED varchar2(4)
    ,EMAIL_ID varchar2(30)
    ,EMAIL_DOMAIN varchar2(30)
    ,BRTHDAY varchar2(6)
    ,USE_FLAG varchar2(1)
    ,CREATED_BY varchar2(25)
    ,CREATED_DATE timestamp default SYSDATE not null
    ,LAST_UPDATE_BY varchar2(25) 
    ,LAST_UPDATE_DATE timestamp default SYSDATE not null
);
-- 생성된 테이블에 pk 부여 
ALTER TABLE user_mst
ADD CONSTRAINT PK_user_mst primary key(USER_NO);

--회원 비밀번호 테이블
CREATE TABLE PASSWORD_MST (
    USER_NO number not null
    ,PASSWORD varchar2(80) not null
    ,LAST_UPDATE_BY varchar2(25) 
    ,LAST_UPDATE_DATE timestamp default sysdate not null
);

--게시판 테이블
CREATE TABLE BOARD_MST (
    BOARD_NO number not null
    ,USER_NO number not null
    ,BOARD_TITLE varchar2(25) not null
    ,BAORD_DETAIL varchar2(1)
    ,USE_FLAG varchar2(1)
    ,CREATED_BY varchar2(25)
    ,CREATED_DATE timestamp default sysdate not null
    ,LAST_UPDATE_BY varchar2(25) 
    ,LAST_UPDATE_DATE timestamp default sysdate not null
);

--조회수 테이블
CREATE TABLE READ_MST (
    USER_NO number not null
    ,BOARD_NO number not null
    ,LAST_READ_DATE timestamp default sysdate not null
);

--댓글 테이블
CREATE TABLE COMMENT_MST (
    COMMNET_NO number not null
    ,COMMENT_STEP number not null
    ,BOARD_NO number not null
    ,USER_NO number not null
    ,COMMENT_DETAIL VARCHAR2(1000)
    ,USE_FLAG varchar2(1)
    ,CREATED_BY varchar2(25)
    ,CREATED_DATE timestamp default sysdate not null
    ,LAST_UPDATE_BY varchar2(25) 
    ,LAST_UPDATE_DATE timestamp default sysdate not null
);

--좋아요 테이블
CREATE TABLE LIKEY_MST (
    COMMNET_NO number not null
    ,COMMENT_STEP number not null
    ,USER_NO number not null
    ,BOARD_NO number not null
);


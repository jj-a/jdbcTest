-- jdbcTest > board2.sql


-- 테이블 생성
CREATE TABLE board2(
idx INT PRIMARY KEY, 
name VARCHAR(10), 
email VARCHAR(50), 
homepage VARCHAR(50), 
title VARCHAR(50), 
content VARCHAR(2000), 
pwd VARCHAR(10), 
wdate DATE, 
hit INT 
)
;

-- 시퀀스 생성
CREATE SEQUENCE board2_idx_seq
;

-- 전체 조회
SELECT * FROM board2
ORDER BY idx DESC 
;

SELECT * FROM board2
WHERE idx>=? AND idx<=? 
ORDER BY idx DESC 
;

INSERT INTO board2(idx, name, email, homepage, title, content, pwd, wdate, hit) 
VALUES(board2_idx_seq.nextval,'어피치', 'apeach@kakao.com', 'kakaofriend.co.kr',
'카카오프렌즈', '어피치', '1234', sysdate, 0)
;

SELECT COUNT(*) FROM board2
;

UPDATE board2 
SET name=? 
WHERE idx=? 
;

DELETE FROM board2
WHERE idx=?
;


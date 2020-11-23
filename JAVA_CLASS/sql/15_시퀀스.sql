-- 15_시퀀스.sql

/*
    # 시퀀스
        - 기본키로 사용하기 편하도록 설계된 자동 번호 발생기
        
        CREATE SEQUENCE 시퀀스명
                        [START WITH n]  - 시퀀스의 시작 번호 설정
                        [INCREMENT BY n] - 시퀀스의 증가값 설정
                        [MAXVALUE n | NOMAXVALUE] - 최대값을 설정
                        [MINVALUE n | NOMINVALUE] - 최소값을 설정
                        [CYCLE | NOCYCLE] - 마지막 값에 도달했을 때 순환 여부 설정
                        [CACHE n | NOCACHE] - 시퀀스를 메모리상에 미리 만들어 놓는 개수를 설정
*/

-- 시퀀스 데이터 딕셔너리 뷰 
SELECT * FROM user_sequences;
SELECT * FROM all_sequences;

CREATE SEQUENCE empp_seq START WITH 100 INCREMENT BY 10;


/*
    # 시퀀스.nextval 
        - 해당 시퀀스의 다음 자동 생성 번호를 받아온다 
        - 다음 번호를 생성한 시퀀스는 다시 예전 번호로 돌아갈 수 없다
*/
SELECT empp_seq.nextval FROM dual;
-- 시퀀스.currval : 해당 시퀀스의 현재 번호를 받아온다 
SELECT empp_seq.currval FROM dual;

SELECT * FROM coffees;

-- 시퀀스는 99.99%정도가 INSERT문과 함께 이용된다
INSERT INTO coffees VALUES (empp_seq.nextval, '아메리카노', 1000);

CREATE SEQUENCE waiting_num START WITH 700 MINVALUE 700 MAXVALUE 710 INCREMENT BY 1 CYCLE NOCACHE;
-- 시퀀스 삭제
DROP SEQUENCE waiting_num;
-- 시퀀스 변경
ALTER SEQUENCE waiting_num MAXVALUE 707 MINVALUE 600 INCREMENT BY 5;

SELECT waiting_num.nextval FROM dual;














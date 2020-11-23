-- 11_테이블 생성.sql

/*
    # DML (Data Manipulation Language, 데이터 조작어)
        - 테이블 내부의 데이터를 검색/추가/수정/삭제하는 명령어
        - SELECT : 검색
        - INSERT : 생성
        - UPDATE : 수정
        - DELETE : 삭제
    
    # DDL (Data Definition Language, 데이터 정의어)
        - 테이블 등(시퀀스, 인덱스, 뷰 ...)의 구조를 생성하는데 사용하는 명령어 
        - CREATE : 생성
        - DROP : 삭제
        - ALTER : 수정
        - TRUNCATE : 완전 삭제 
        
    # DCL (Data Control Language, 데이터 제어 명령어)
        - 사용자의 권한을 관리하는데 사용하는 명령어
        - GRANT : 사용자에게 권한을 부여
        - REVOKE : 사용자의 권한을 회수
*/

/*
    # 테이블 생성
        CREATE TABLE 테이블명 (컬럼이름1 컬럼타입1, 컬럼이름2 컬럼타입2, ....);
*/
CREATE TABLE coffees (
    CID NUMBER(4),
    CNAME VARCHAR2(30),
    CPRICE NUMBER(6)
);

DESC coffees;

-- # 기존에 존재하는 테이블을 복제하면서 만들기 
CREATE TABLE employees2 AS SELECT * FROM employees;
CREATE TABLE employees3 AS (SELECT last_name AS 이름, salary AS 월급, job_id AS 직급 FROM employees);

-- # 테이블 삭제하기 
drop table coffees;
drop table employees2;

-- # 휴지통 검색
show recyclebin;
select * from recyclebin;

-- # 휴지통 복구하기
FLASHBACK TABLE coffees TO BEFORE DROP;

-- # 휴지통 비우기
PURGE recyclebin;

-- # 휴지통 거치지 않고 바로 테이블 삭제
DROP TABLE coffees PURGE;
DROP TABLE employees3 PURGE;


-- 연습문제01: 50번 부서 사람들로만 구성된 테이블을 하나 생성해보세요
CREATE TABLE dept50 AS SELECT * FROM employees WHERE department_id = 50;
DROP TABLE dept50 PURGE;


-- # 테이블의 구조만 복사하기 (일부러 말도 안되는 조건을 넣고 테이블 복사)
CREATE TABLE employeee AS SELECT * FROM employees WHERE 1 = 0;
DESC employeee;
DROP TABLE employeee PURGE;


-- # 테이블 구조 변경 명령어들 
CREATE TABLE coffees (
    CID NUMBER(4),
    CNAME VARCHAR2(30),
    CPRICE NUMBER(6)
);

-- # ALTER TABLE 테이블명 ADD (컬럼명1 컬럼타입1, 컬럼명2 컬럼타입2, ...)
ALTER TABLE coffees ADD (
    location_id NUMBER(4),
    acidity NUMBER(4, 2)
);
DESC coffees;

-- # ALTER TABLE 테이블명 MODIFY (컬럼명 컬럼타입, ...)
--   - 컬럼을 변경할 때는 데이터 타입이나 크기 등을 변경할 수 있다
--   - 컬럼명은 변경할 수 없다
ALTER TABLE coffees MODIFY (
    cid number(3),
    cname varchar2(50)
);
DESC coffees;

-- # ALTER TABLE 테이블명 DROP COLUMN 컬럼명;
ALTER TABLE coffees DROP COLUMN acidity;
DESC coffees;

-- # ALTER TABLE 테이블명 SET UNUSED(컬럼명) : 삭제할 준비 시키기 (SET UNUSED)
--  - 해당 컬럼을 삭제하기 전에 사용하지 못하는 상태로 변경한다 
--  - 물리적인 삭제는 나중에 진행할 때 사용한다
--  - 테이블에 저장된 행이 많을 때 안전한 시간에 삭제하기 위해 진행한다
ALTER TABLE coffees SET UNUSED(location_id);
DESC coffees;

-- 안전한 시간대에 삭제를 진행한다
ALTER TABLE coffees DROP UNUSED COLUMNS;


-- # 테이블명 변경하기
RENAME coffees TO coffee_shop;

-- # 컬럼명 수정하기
ALTER TABLE coffee_shop RENAME COLUMN cid TO cfid;
DESC coffee_shop;

/*
    # 데이터 딕셔너리
        - 우리가 테이블을 추가하면 DB에 존재하는 테이블의 정보를 DBMS가 알아서 관리한다
        - 이처럼 사용자가 직접 관리하는 것이 아닌 데이터들을 데이터 딕셔너리라고 부른다
        
    # 데이터 딕셔너리 뷰 
        - 데이터 딕셔너리를 사용자가 보기 편리하도록 변환하여 제공하는 뷰(View)    
*/

-- # 테이블 데이터 딕셔너리 뷰
SELECT * FROM tab;
SELECT * FROM tabs;
SELECT * FROM user_tables; -- USER_ : 현재 USER가 가지고 있는 정보만 보여주는 데이터 딕셔너리 뷰
SELECT * FROM all_tables;  -- ALL_  : 모든 USER가 가지고 있는 정보를 보여주는 데이터 딕셔너리 뷰

-- # 제약조건(constraints) 데이터 딕셔너리 뷰
SELECT * FROM user_constraints;
SELECT * FROM all_constraints;

SHOW USER;








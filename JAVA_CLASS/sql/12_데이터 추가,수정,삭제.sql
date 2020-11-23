-- 12_데이터 추가,수정,삭제.sql


/*
    # INSERT : 테이블에 새로운 데이터 추가(생성)
    
        INSERT INTO 테이블명(컬럼명, ..) VALUES(값, ..)
*/
DESC coffees;

-- # 가장 기본적인 데이터 추가
INSERT INTO coffees(cfid, cname, cprice) VALUES(1, '아이스 아메리카노', 2000);
INSERT INTO coffees(cname, cfid, cprice) VALUES('뜨거운 아메리카노', 2, 2000);

-- # 일부 컬럼에만 데이터 추가
INSERT INTO coffees(cname, cprice) VALUES('아이스 카페라떼', 2500);
INSERT INTO coffees(cprice, cfid) VALUES(2500, 4);

-- # 컬럼을 생략하면서 데이터 추가 (모든 컬럼에 순서대로 모든 값을 넣어야 함)
INSERT INTO coffees VALUES(5, '아이스 카페모카', 3000);
INSERT INTO coffees VALUES(5, '아이스 카페모카', 3000);

SELECT * FROM coffees;


-- # 서브쿼리로 데이터 삽입하기 
INSERT INTO coffees SELECT * FROM coffees;

/*
    # UPDATE : 테이블의 데이터를 수정 
    
        - UPDATE 테이블명 SET 컬럼명 = 값, ... WHERE 수정할 행의 조건;
        - UPDATE문에 조건을 입력하지 않으면 모든 행이 수정된다
        - 조건을 만족하는 모든 행을 수정한다
        - 하나의 행을 구분할 수 있는 기본키와 함께 이용되는 경우가 대부분이다
*/
UPDATE coffees SET cprice = cprice + 200 WHERE cfid = 2;


-- 연습문제01: employees 테이블의 구조만 복사하는 쿼리문을 이용하여 emp 테이블을 생성해보세요
CREATE TABLE emp AS SELECT * FROM employees WHERE 1 != 1;
select * from emp;
desc emp;

-- 연습문제02: emp테이블에 employees의 모든 사원들 중 홀수 사번을 가진 사원들만 추가해보세요
INSERT INTO emp SELECT * FROM employees WHERE MOD(employee_id, 2) = 1;

-- 연습문제03: emp테이블의 모든 사원들 중 JOB_ID에 MAN이 포함된 사원들의 월급을 40%삭감 해보세요 
UPDATE emp SET salary = salary * 0.6 WHERE job_id LIKE '%MAN%';


/*
    # DELETE
    
        - DELETE FROM 테이블명 WHERE 조건;
        - 조건이 없으면 모든 행을 지운다
        - 조건에 맞는 모든 행을 지운다
*/
COMMIT;

SELECT * FROM coffees;
DELETE FROM coffees WHERE cname LIKE '%아메리카노%';

ROLLBACK;











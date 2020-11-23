-- 03_WHERE.sql

-- SELECT문에 WHERE절을 추가해 해당 조건을 만족하는 데이터만 조회할 수 있다

-- SELECT 컬럼명 FROM 테이블명 WHERE 조건절;
-- ex: 월급이 15000 이상인 사원의 이름 조회하기 
SELECT last_name FROM employees WHERE salary >= 15000;

-- 오라클의 비교 연산자들

/* = : 같다 */
SELECT * FROM employees WHERE salary = 9000;
SELECT * FROM employees WHERE commission_pct = 0.25;
-- 오라클에서 문자열 리터럴을 나타낼때는 반드시 ''를 사용해야 한다 
SELECT * FROM employees WHERE first_name = 'Lisa';
-- 날짜 타입도 크기 비교가 가능하다 
SELECT * FROM employees WHERE hire_date = '2003/06/17';

/* <, >, <=, >= : 비교 */
SELECT * FROM employees WHERE employee_id < 110;
SELECT * FROM employees WHERE last_name < 'C';
SELECT * FROM employees WHERE hire_date > '2006/12/31';

/* !=, <>, ^= : 다르다 */
SELECT * FROM employees WHERE job_id <> 'IT_PROG';
SELECT * FROM employees WHERE job_id != 'IT_PROG';
SELECT * FROM employees WHERE job_id ^= 'IT_PROG';

/* 
    AND, OR, NOT
*/
SELECT * FROM employees WHERE first_name > 'N' AND first_name < 'P';
SELECT * FROM employees WHERE job_id = 'IT_PROG' OR job_id = 'FI_MGR';

-- NOT의 위치는 비교적 자유롭다 
SELECT * FROM employees WHERE job_id = 'IT_PROG' AND NOT salary < 5000;
SELECT * FROM employees WHERE NOT job_id = 'IT_PROG' AND salary < 5000;
SELECT * FROM employees WHERE NOT (job_id = 'IT_PROG' AND salary < 5000);

-- 연습문제01 : 2000에서 3000사이의 월급을 받는 사원들의 모든 정보를 조회해보세요
SELECT * FROM employees WHERE salary >= 2000 AND salary <= 3000;
SELECT * FROM employees WHERE salary BETWEEN 2000 AND 3000;

-- 연습문제02 : 부서번호가 30번이거나 60번이거나 90번인 사원들의 모든 정보를 조회해보세요
SELECT 
    * 
FROM 
    employees 
WHERE 
    department_id = 30 OR 
    department_id = 60 OR
    department_id = 90;

-- 연습문제03 : 사원번호가 짝수인 사원들만 조회해보세요
SELECT * FROM employees WHERE MOD(employee_id, 2) = 0;


-- COLUMN BETWEEN A AND B : 해당 컬럼의 값이 A 이상 B 이하일때 True
SELECT * FROM employees WHERE salary BETWEEN 2000 AND 3000;
SELECT * FROM employees WHERE hire_date BETWEEN '05/07/01' AND '05/12/31';

-- COLUMN IN (A, B, C ...) : ()안의 내용에 해당 값이 존재하면 true
SELECT * FROM employees WHERE department_id IN (30, 60, 90);
SELECT * FROM employees WHERE job_id IN ('PU_MAN', 'PU_CLERK', 'IT_PROG');
SELECT * FROM employees WHERE job_id NOT IN ('PU_MAN', 'PU_CLERK', 'IT_PROG');

-- 보너스 금액이 NULL인 모든 사원을 조회해보기
SELECT * FROM employees WHERE commission_pct = NULL; -- 아무것도 안나옴

-- 값이 NULL인 조건을 만들때는 IS NULL을 이용해야 한다 (NULL은 크기 비교가 불가능하다)
SELECT * FROM employees WHERE commission_pct IS NULL;
SELECT * FROM employees WHERE commission_pct IS NOT NULL;


-- LIKE 
/*
    - 데이터의 일부분으로 원하는 내용을 검색할 수 있다 
    - % : 아무 문자열이나 와도 되는 자리 (없어도 됨)
    - _ : 하나의 문자가 반드시 와야 하는 자리     
*/

-- 핸드폰 번호가 515.으로 시작하는 모든 튜플을 조회
SELECT * FROM employees WHERE phone_number LIKE '515.%';

-- 핸드폰 번호에 .123.이 포함된 모든 튜플을 조회
SELECT * FROM employees WHERE phone_number LIKE '%.123.%';

-- LAST_NAME의 두 번째 글자가 a인 모든 행을 조회
SELECT * FROM employees WHERE last_name LIKE '_a%';

-- LAST_NAME에 a가 두 개 이상 포함된 모든 행을 조회
SELECT * FROM employees WHERE last_name LIKE '%a%a%';


-- 연습문제04 : LAST_NAME의 뒤에서 세 번째 글자가 a인 모든 사원을 조회해보세요

-- 연습문제05 : LAST_NAME의 3번째 글자가 r이고 핸드폰 번호에 .이 3개 포함된 
--            모든 사원을 조회해보세요 











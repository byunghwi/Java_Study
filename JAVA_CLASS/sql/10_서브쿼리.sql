-- 10_서브쿼리.sql

/*
    # 서브쿼리
        - 하나의 SELECT 문장에 포함된 또 하나의 SELECT 문장
        - 서브 쿼리를 포함하고 있는 쿼리를 메인 쿼리라고 한다 
        - 서브 쿼리로 비교 연산을 하는 경우에는 반드시 연산자의 오른쪽에 기술해야 한다
        - 반드시 괄호로 둘러쌓아야 한다
        - 서브 쿼리는 메인 쿼리가 실행되기 전에 한번만 실행 된다
        
    # 단일 행 서브 쿼리 
        - 서브 쿼리의 수행 결과가 단 하나의 행만 반환하는 서브 쿼리
        - =, >, >=, <, <=, <>등은 하나의 값만 요구하는 비교 연산자 이므로
          단일 행 서브 쿼리와 함께 사용해야 한다 
*/

SELECT
    *
FROM
    employees
WHERE
    last_name = 'King';

-- King과 같은 부서에 근무하는 사원의 정보를 서브쿼리를 이용해 조회해보기 
SELECT
    *
FROM
    employees
WHERE
    department_id = (
        SELECT
            department_id
        FROM
            employees
        WHERE
                last_name = 'King'
            AND first_name LIKE 'S%'
    ); -- 단일 행 연산자는 서브 쿼리의 결과가 단일 행이 아닌 경우 에러가 발생한다 
    
    
-- 연습문제01: 서브쿼리를 이용해 Ki Gee와 동일한 직급을 가진 사원을 조회해보세요 
SELECT
    *
FROM
    employees
WHERE
    job_id = (
        SELECT
            job_id
        FROM
            employees
        WHERE
                first_name = 'Ki'
            AND last_name = 'Gee'
    );

-- 연습문제02: 서브쿼리를 이용해 Ki Gee보다 급여를 많이 받는 사원들의 이름과 급여를 조회해보세요 
SELECT
    *
FROM
    employees
WHERE
    salary > (
        SELECT
            salary
        FROM
            employees
        WHERE
                first_name = 'Ki'
            AND last_name = 'Gee'
    );


-- 연습문제03: 서브쿼리를 이용해 Purchasing부서에서 근무하는 사원의 이름과 부서번호를 조회해보세요
SELECT
    first_name,
    last_name,
    department_id
FROM
    employees
WHERE
    department_id = (
        SELECT
            department_id
        FROM
            departments
        WHERE
            department_name = 'Purchasing'
    );
    
/*
    # 다중 행 서브 쿼리
        - 서브 쿼리에서 반환되는 결과가 하나 이상의 행인 서브 쿼리 
        - 다중 행 연산자와 함께 사용해야 한다 
        - IN : 서브 쿼리의 결과 중에서 하나라도 일치하면 참
        - ANY, SOME : 서브 쿼리의 결과와 하나 이상 일치하면 참 
        - ALL : 서브 쿼리의 결과와 모든 값이 일치해야 참
*/

-- 급여가 10000$ 이상인 사원이 소속된 부서에서 근무하는 모든 사원을 조회
SELECT
    last_name,
    salary,
    department_id
FROM
    employees
WHERE
    department_id IN (
        SELECT DISTINCT
            department_id
        FROM
            employees
        WHERE
            salary >= 10000
    ) -- (20, 30, 70, 80, 90, 100, 110) : 다중 행 서브쿼리는 다중 행 연산자와 함께 사용해야 한다 
ORDER BY
    department_id ASC;
    
    
-- ALL 연산자

-- 50번 부서의 모든 사원보다 급여를 많이 받는 사원들을 조회
--  => 50번 부서에서 제일 많이 받는 사원보다 더 많이 받는 사원들을 조회
SELECT
    *
FROM
    employees
WHERE
    salary > ALL (
        SELECT
            salary
        FROM
            employees
        WHERE
            department_id = 100
    );


-- 연습문제04: 프로그래머들 보다 급여를 많이 받는 사원들의 이름/급여/직책ID를 출력하되
-- 프로그래머는 출력하지 말아보세요
SELECT
    first_name,
    salary,
    job_id
FROM
    employees
WHERE
    salary > ALL (
        SELECT
            salary
        FROM
            employees
        WHERE
            job_id = 'IT_PROG'
    );
    
-- ANY, SOME 연산자
--  - 서브 쿼리의 모든 결과 들 중 하나 이상만 일치하면 참 

-- 50번 부서의 모든 사원들 중 가장 적게 받는 사원보다 많이 받는 사원을 모두 조회
SELECT * FROM employees WHERE salary > SOME (SELECT salary FROM employees WHERE department_id = 50);

-- 50번 부서의 모든 사원들 중 가장 많이 받는 사원보다 적게 받는 사원을 모두 조회
SELECT * FROM employees WHERE salary < SOME (SELECT salary FROM employees WHERE department_id = 50);


-- 연습문제05: 가장 적게 받는 프로그래머보다 많이 받는 모든 사원을 조회해보세요
SELECT * FROM employees WHERE salary > ANY (SELECT salary FROM employees WHERE job_id = 'IT_PROG');


-- EXISTS
--  - 해당 서브 쿼리의 실행 결과가 존재하면 참이 된다
--  - 서브 쿼리를 수행하던 중에 행이 하나라도 발견되면 바로 True가 된다

-- job_history 테이블에 기록이 존재하는 사원을 보고 싶은 경우 
SELECT *
FROM
    employees
WHERE
    EXISTS (
        SELECT
            1
        FROM
            job_history
        WHERE
            employees.employee_id = job_history.employee_id
    );

SELECT * FROM employees WHERE employee_id IN (SELECT DISTINCT employee_id FROM job_history);
SELECT * FROM employees WHERE employee_id = ANY (SELECT DISTINCT employee_id FROM job_history);

select * from tab;
select * from job_history;









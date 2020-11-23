-- 09_ANSI JOIN.sql

-- ANSI(미국 국가 표준 협회)에서 정한 표준을 따르는 JOIN문법

-- ANSI CROSS JOIN
SELECT
    *
FROM
         employees
    CROSS JOIN departments;

-- ANSI INNER JOIN : 조건에 맞는 행만 등장하는 JOIN
SELECT
    *
FROM
         employees e
    INNER JOIN departments d ON e.department_id = d.department_id;

/*
    ANSI OUTER JOIN : 조건에 안 맞는 행도 보고싶을 때 사용하는 JOIN
    
        - LEFT OUTER JOIN : 오른쪽에 (+)를 붙인 경우와 같음
        - RIGHT OUTER JOIN : 왼쪽에 (+)를 붙인 경우와 같음 
        - FULL OUTER JOIN : 양쪽에 (+)를 붙인 경우와 같음 
*/

-- RIGHT OUTER JOIN
SELECT
    first_name,
    department_name
FROM
    employees    e
    RIGHT OUTER JOIN departments  d ON e.department_id = d.department_id;

-- LEFT OUTER JOIN
SELECT
    last_name,
    department_name
FROM
    employees    e
    LEFT OUTER JOIN departments  d ON e.department_id = d.department_id;

-- FULL OUTER JOIN
SELECT
    last_name,
    department_name
FROM
    employees    e
    FULL OUTER JOIN departments  d ON e.department_id = d.department_id
                                     AND last_name = 'King'
ORDER BY
    last_name ASC;

-- ANSI JOIN을 이용할 때 JOIN 조건에 이용되는 컬럼명이 같은 경우 
-- USING을 이용해 쿼리문을 간소화 할 수 있다
SELECT
    *
FROM
         employees e
    INNER JOIN departments d USING ( department_id );

SELECT
    *
FROM
    employees    e
    LEFT OUTER JOIN departments  d USING ( department_id );

SELECT
    *
FROM
    employees    e
    RIGHT OUTER JOIN departments  d USING ( department_id );

SELECT
    *
FROM
    employees    e
    FULL OUTER JOIN departments  d USING ( department_id );

-- JOIN에 사용되는 조건과 필요해서 사용하는 조건이 구분된다 
-- USING에 사용된 컬럼은 어느 테이블의 컬럼인지 명확히 할 필요가 없어진다
SELECT
    last_name,
    department_id,
    department_name
FROM
         employees e
    INNER JOIN departments d USING ( department_id )
WHERE
    salary <= 10000
ORDER BY
    salary DESC;

-- ANSI JOIN을 이용하여 풀어보세요

-- 연습문제01: FIRST_NAME이 Neena인 사원과 같은 도시에서 근무하는 모든 사원의 이름과 부서번호를 조회해보세요
SELECT
    first_name,
    last_name,
    department_id
FROM
         employees
    INNER JOIN departments USING ( department_id )
    INNER JOIN locations USING ( location_id )
WHERE
    city = (
        SELECT
            city
        FROM
                 employees
            INNER JOIN departments USING ( department_id )
            INNER JOIN locations USING ( location_id )
        WHERE
            first_name = 'Neena'
    );

-- 연습문제02: FIRST_NAME이 Neena인 사원과 급여차이가 5천 이하인 모든 사원을 조회해보세요
SELECT
    e1.*
FROM
         employees e1
    INNER JOIN employees e2 ON e2.first_name = 'Neena'
                               AND abs(e2.salary - e1.salary) <= 5000
ORDER BY
    e1.salary DESC;
                    -- e1.salary BETWEEN e2.salary - 5000 AND e2.salary + 5000;


-- 연습문제03: 시애틀에서 근무하는 모든 사원의 이름/부서명/도시를 조회
SELECT
    first_name,
    last_name,
    department_name,
    city
FROM
         employees
    INNER JOIN departments USING ( department_id )
    INNER JOIN locations USING ( location_id )
WHERE
    city = 'Seattle';


-- 연습문제04: 매니저의 이름이 King인 모든 사원의 이름/직책명/연봉을 조회
SELECT
    e1.first_name,
    e1.last_name,
    jobs.job_title,
    e1.salary * ( nvl(e1.commission_pct, 0) + 1 ) * 12
FROM
         employees e1
    INNER JOIN employees e2 ON e1.manager_id = e2.employee_id
                               AND e2.last_name = 'King'
    INNER JOIN jobs ON e1.job_id = jobs.job_id;
    
    

-- 06_그룹 함수.sql

-- # 그룹 함수
/*
    - 여러 행의 값을 취합하는 함수들
    - 총합, 개수, 평균, 최대, 최소, ...        
*/

-- SUM(COL) : 해당 컬럼의 모든 행의 총합을 구한다
SELECT SUM(salary) AS 총월급 FROM employees;
SELECT SUM(commission_pct) FROM employees;

-- AVG(COL) : 해당 컬럼의 모든 행의 평균을 구한다
SELECT TRUNC(AVG(salary), 2) AS 평균월급 FROM employees;
SELECT ROUND(AVG(salary), 2) AS 평균월급 FROM employees;

-- MAX(COL) : 해당 컬럼의 모든 값들 중 최대 값을 구한다
-- MIN(COL) : 해당 컬럼의 모든 값들 중 최소 값을 구한다
SELECT MAX(salary) FROM employees;
SELECT MIN(salary) FROM employees;

-- ※ 그룹 함수는 일반 컬럼과 함께 사용할 수 없다
SELECT 
    last_name, salary 
FROM 
    employees 
WHERE 
    salary = (SELECT MAX(salary) FROM employees);

-- 연습문제01 : 가장 최근에 입사한 사원의 입사일과 
-- 입사한지 가장 오래된 사원의 입사일을 출력하는 쿼리문을 작성해보세요
SELECT MAX(hire_date), MIN(hire_date) FROM employees;
-- ※ 그룹 함수는 그룹 함수끼리는 함께 사용할 수 있다


-- COUNT(COL) : 해당 컬럼의 행의 개수를 구한다
SELECT COUNT(salary) FROM employees;
SELECT COUNT(commission_pct) FROM employees; -- null의 개수는 세지 않는다
SELECT COUNT(*) FROM employees; -- 모든 행을 센다
SELECT 
    COUNT(*) AS "전체 사원 수", 
    COUNT(commission_pct) AS "보너스 받는 사원 수",
    TRUNC(COUNT(commission_pct) / COUNT(*) * 100, 2) AS "보너스 받는 사원의 비율"
FROM 
    employees;

-- 80번 부서 사람들 중 보너스 받는 사원의 수 
SELECT 
    COUNT(commission_pct) 
FROM 
    employees 
WHERE 
    department_id = 80 AND commission_pct > 0;

-- GROUP BY
/*
    - 그룹 함수를 그룹 별로 적용한 결과를 얻어낼 수 있다
    - GROUP BY로 설정한 컬럼을 이용해 그룹을 나누게 된다
    - GROUP으로 나눈 경우에는 그룹을 나누는 기준이되는 컬럼과 그룹 함수의 결과만
      컬럼으로 선택할 수 있다
*/
SELECT COUNT(*), job_id FROM employees GROUP BY job_id;
SELECT COUNT(*), department_id FROM employees GROUP BY department_id;

-- 연습문제02 : 각 직책별 평균 연봉을 구해보세요 (※ 월급 아님, 커미션 적용)
SELECT 
    job_id, 
    TRUNC(AVG(salary * (NVL(commission_pct, 0) + 1)) * 12)  AS "평균 연봉", 
    COUNT(*) 
FROM 
    employees 
GROUP BY 
    job_id;


-- # 그룹 함수의 결과를 조건에 사용하고 싶은 경우에는 HAVING절을 이용한다

-- 소속된 사원이 10명 이상인 직책
SELECT job_id FROM employees GROUP BY job_id HAVING COUNT(*) >= 10;

-- 소속된 사원이 10명 이상인 부서
SELECT department_id FROM employees GROUP BY department_id HAVING COUNT(*) >= 10;


-- 연습문제03 : 부서별 최대 급여와 최소 급여를 출력하되 최대 급여가 5000이상인 부서만 출력해보세요
SELECT MAX(salary), MIN(salary) FROM employees GROUP BY department_id HAVING MAX(salary) >= 5000;

-- 연습문제04 : 부서별 평균 급여를 출력하되 해당 부서에 소속된 사원이 5명 이상인 경우에만 출력해보세요
SELECT 
    ROUND(AVG(salary), 2), 
    department_id 
FROM 
    employees 
GROUP BY 
    department_id 
HAVING 
    COUNT(*) >= 5;

-- 각 매니저가 몇 명씩 맡고 있는지를 알 수 있음
SELECT COUNT(*), manager_id FROM employees GROUP BY manager_id;

-- 각 매니저가 맡은 사원들 중에 직급이 있는 사원이 몇 명 인지를 알 수 있음
SELECT COUNT(job_id), manager_id FROM employees GROUP BY manager_id;

-- 각 매니저가 맡은 사원들 중에 보너스를 받는 사원이 몇 명 인지를 알 수 있음
SELECT COUNT(commission_pct), manager_id FROM employees GROUP BY manager_id;

SELECT commission_pct FROM employees;

-- 카페, 병원, 음식점, 쇼핑몰, 편의점 .. 등을 운영하는데에 필요한 프로그램
-- gurwns2030@gmail.com : 같이 하고 싶은 사람 이름 적어서 보내주세요
-- 본인 이름 : 
-- 같이 하고 싶은 사람 이름 : 


















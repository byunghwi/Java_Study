-- 04_집합.sql
 

-- UNION : 합집합 (중복은 알아서 제거)
SELECT * FROM departments WHERE department_id BETWEEN 10 AND 50
UNION
SELECT * FROM departments WHERE department_id BETWEEN 40 AND 80;

-- UNION ALL : 합집합 (중복 제거 안함)
SELECT * FROM departments WHERE department_id BETWEEN 10 AND 50
UNION ALL
SELECT * FROM departments WHERE department_id BETWEEN 40 AND 80;

-- INTERSECT : 교집합
SELECT * FROM departments WHERE department_id BETWEEN 10 AND 50
INTERSECT
SELECT * FROM departments WHERE department_id BETWEEN 40 AND 80;

-- MINUS : 차집합
SELECT * FROM departments WHERE department_id BETWEEN 10 AND 50
MINUS
SELECT * FROM departments WHERE department_id BETWEEN 40 AND 80;

SELECT * FROM departments WHERE department_id BETWEEN 40 AND 80
MINUS
SELECT * FROM departments WHERE department_id BETWEEN 10 AND 50;





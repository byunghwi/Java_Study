-- 04_����.sql
 

-- UNION : ������ (�ߺ��� �˾Ƽ� ����)
SELECT * FROM departments WHERE department_id BETWEEN 10 AND 50
UNION
SELECT * FROM departments WHERE department_id BETWEEN 40 AND 80;

-- UNION ALL : ������ (�ߺ� ���� ����)
SELECT * FROM departments WHERE department_id BETWEEN 10 AND 50
UNION ALL
SELECT * FROM departments WHERE department_id BETWEEN 40 AND 80;

-- INTERSECT : ������
SELECT * FROM departments WHERE department_id BETWEEN 10 AND 50
INTERSECT
SELECT * FROM departments WHERE department_id BETWEEN 40 AND 80;

-- MINUS : ������
SELECT * FROM departments WHERE department_id BETWEEN 10 AND 50
MINUS
SELECT * FROM departments WHERE department_id BETWEEN 40 AND 80;

SELECT * FROM departments WHERE department_id BETWEEN 40 AND 80
MINUS
SELECT * FROM departments WHERE department_id BETWEEN 10 AND 50;





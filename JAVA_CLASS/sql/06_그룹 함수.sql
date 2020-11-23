-- 06_�׷� �Լ�.sql

-- # �׷� �Լ�
/*
    - ���� ���� ���� �����ϴ� �Լ���
    - ����, ����, ���, �ִ�, �ּ�, ...        
*/

-- SUM(COL) : �ش� �÷��� ��� ���� ������ ���Ѵ�
SELECT SUM(salary) AS �ѿ��� FROM employees;
SELECT SUM(commission_pct) FROM employees;

-- AVG(COL) : �ش� �÷��� ��� ���� ����� ���Ѵ�
SELECT TRUNC(AVG(salary), 2) AS ��տ��� FROM employees;
SELECT ROUND(AVG(salary), 2) AS ��տ��� FROM employees;

-- MAX(COL) : �ش� �÷��� ��� ���� �� �ִ� ���� ���Ѵ�
-- MIN(COL) : �ش� �÷��� ��� ���� �� �ּ� ���� ���Ѵ�
SELECT MAX(salary) FROM employees;
SELECT MIN(salary) FROM employees;

-- �� �׷� �Լ��� �Ϲ� �÷��� �Բ� ����� �� ����
SELECT 
    last_name, salary 
FROM 
    employees 
WHERE 
    salary = (SELECT MAX(salary) FROM employees);

-- ��������01 : ���� �ֱٿ� �Ի��� ����� �Ի��ϰ� 
-- �Ի����� ���� ������ ����� �Ի����� ����ϴ� �������� �ۼ��غ�����
SELECT MAX(hire_date), MIN(hire_date) FROM employees;
-- �� �׷� �Լ��� �׷� �Լ������� �Բ� ����� �� �ִ�


-- COUNT(COL) : �ش� �÷��� ���� ������ ���Ѵ�
SELECT COUNT(salary) FROM employees;
SELECT COUNT(commission_pct) FROM employees; -- null�� ������ ���� �ʴ´�
SELECT COUNT(*) FROM employees; -- ��� ���� ����
SELECT 
    COUNT(*) AS "��ü ��� ��", 
    COUNT(commission_pct) AS "���ʽ� �޴� ��� ��",
    TRUNC(COUNT(commission_pct) / COUNT(*) * 100, 2) AS "���ʽ� �޴� ����� ����"
FROM 
    employees;

-- 80�� �μ� ����� �� ���ʽ� �޴� ����� �� 
SELECT 
    COUNT(commission_pct) 
FROM 
    employees 
WHERE 
    department_id = 80 AND commission_pct > 0;

-- GROUP BY
/*
    - �׷� �Լ��� �׷� ���� ������ ����� �� �� �ִ�
    - GROUP BY�� ������ �÷��� �̿��� �׷��� ������ �ȴ�
    - GROUP���� ���� ��쿡�� �׷��� ������ �����̵Ǵ� �÷��� �׷� �Լ��� �����
      �÷����� ������ �� �ִ�
*/
SELECT COUNT(*), job_id FROM employees GROUP BY job_id;
SELECT COUNT(*), department_id FROM employees GROUP BY department_id;

-- ��������02 : �� ��å�� ��� ������ ���غ����� (�� ���� �ƴ�, Ŀ�̼� ����)
SELECT 
    job_id, 
    TRUNC(AVG(salary * (NVL(commission_pct, 0) + 1)) * 12)  AS "��� ����", 
    COUNT(*) 
FROM 
    employees 
GROUP BY 
    job_id;


-- # �׷� �Լ��� ����� ���ǿ� ����ϰ� ���� ��쿡�� HAVING���� �̿��Ѵ�

-- �Ҽӵ� ����� 10�� �̻��� ��å
SELECT job_id FROM employees GROUP BY job_id HAVING COUNT(*) >= 10;

-- �Ҽӵ� ����� 10�� �̻��� �μ�
SELECT department_id FROM employees GROUP BY department_id HAVING COUNT(*) >= 10;


-- ��������03 : �μ��� �ִ� �޿��� �ּ� �޿��� ����ϵ� �ִ� �޿��� 5000�̻��� �μ��� ����غ�����
SELECT MAX(salary), MIN(salary) FROM employees GROUP BY department_id HAVING MAX(salary) >= 5000;

-- ��������04 : �μ��� ��� �޿��� ����ϵ� �ش� �μ��� �Ҽӵ� ����� 5�� �̻��� ��쿡�� ����غ�����
SELECT 
    ROUND(AVG(salary), 2), 
    department_id 
FROM 
    employees 
GROUP BY 
    department_id 
HAVING 
    COUNT(*) >= 5;

-- �� �Ŵ����� �� �� �ð� �ִ����� �� �� ����
SELECT COUNT(*), manager_id FROM employees GROUP BY manager_id;

-- �� �Ŵ����� ���� ����� �߿� ������ �ִ� ����� �� �� ������ �� �� ����
SELECT COUNT(job_id), manager_id FROM employees GROUP BY manager_id;

-- �� �Ŵ����� ���� ����� �߿� ���ʽ��� �޴� ����� �� �� ������ �� �� ����
SELECT COUNT(commission_pct), manager_id FROM employees GROUP BY manager_id;

SELECT commission_pct FROM employees;

-- ī��, ����, ������, ���θ�, ������ .. ���� ��ϴµ��� �ʿ��� ���α׷�
-- gurwns2030@gmail.com : ���� �ϰ� ���� ��� �̸� ��� �����ּ���
-- ���� �̸� : 
-- ���� �ϰ� ���� ��� �̸� : 


















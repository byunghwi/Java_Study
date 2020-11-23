-- 07_����.sql

-- ORDER BY
/*
    - ORDER BY ���� ���� ��ȸ�� ������ ���ϴ� �÷� �������� ������ �� �ִ�
    - ORDER BY �÷��� ASC : ASCENDING, ��������, ���� ���� 
    - ORDER BY �÷��� DESC: DESCENDING, ��������, ���� �Ұ���
*/

SELECT * FROM employees; -- �⺻�����δ� �ε��� �������� ��ȸ�� �ȴ�

SELECT * FROM employees ORDER BY salary; -- ���� ���� ��������
SELECT * FROM employees ORDER BY salary DESC; -- ���� ���� ��������

-- # ���� ������ ������ �� �� �ִ�
--  ex: ���� ���޼����� ������ ��, LAST_NAME ���ĺ� ������ ������ ��, ������� ���� 
SELECT * FROM employees ORDER BY job_id DESC, last_name, employee_id;


-- # GROUP BY�� ����� �Բ� ����ϱ� 
SELECT COUNT(*), job_id FROM employees GROUP BY job_id ORDER BY COUNT(*) DESC;


-- ��������01 : ��� ������� ��ȸ�ϵ� �μ���ȣ�� ������ �� 
-- ���� �μ������� FIRST_NAME ���ĺ������� �����غ�����
SELECT * FROM employees ORDER BY department_id, first_name;

-- ��������02 : ��� ������� �ֱ� �Ի��� ������� ��ȸ�غ����� 
SELECT * FROM employees ORDER BY hire_date DESC;

-- ��������03 : ���� ������ �ִ� ������� ������, ���� �������� �����Ͽ� ��ȸ�غ�����
SELECT 
    * 
FROM 
    employees 
WHERE 
    employee_id IN (SELECT DISTINCT manager_id FROM employees WHERE manager_id IS NOT NULL)
ORDER BY
    salary DESC;










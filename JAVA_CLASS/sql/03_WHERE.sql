-- 03_WHERE.sql

-- SELECT���� WHERE���� �߰��� �ش� ������ �����ϴ� �����͸� ��ȸ�� �� �ִ�

-- SELECT �÷��� FROM ���̺�� WHERE ������;
-- ex: ������ 15000 �̻��� ����� �̸� ��ȸ�ϱ� 
SELECT last_name FROM employees WHERE salary >= 15000;

-- ����Ŭ�� �� �����ڵ�

/* = : ���� */
SELECT * FROM employees WHERE salary = 9000;
SELECT * FROM employees WHERE commission_pct = 0.25;
-- ����Ŭ���� ���ڿ� ���ͷ��� ��Ÿ������ �ݵ�� ''�� ����ؾ� �Ѵ� 
SELECT * FROM employees WHERE first_name = 'Lisa';
-- ��¥ Ÿ�Ե� ũ�� �񱳰� �����ϴ� 
SELECT * FROM employees WHERE hire_date = '2003/06/17';

/* <, >, <=, >= : �� */
SELECT * FROM employees WHERE employee_id < 110;
SELECT * FROM employees WHERE last_name < 'C';
SELECT * FROM employees WHERE hire_date > '2006/12/31';

/* !=, <>, ^= : �ٸ��� */
SELECT * FROM employees WHERE job_id <> 'IT_PROG';
SELECT * FROM employees WHERE job_id != 'IT_PROG';
SELECT * FROM employees WHERE job_id ^= 'IT_PROG';

/* 
    AND, OR, NOT
*/
SELECT * FROM employees WHERE first_name > 'N' AND first_name < 'P';
SELECT * FROM employees WHERE job_id = 'IT_PROG' OR job_id = 'FI_MGR';

-- NOT�� ��ġ�� ���� �����Ӵ� 
SELECT * FROM employees WHERE job_id = 'IT_PROG' AND NOT salary < 5000;
SELECT * FROM employees WHERE NOT job_id = 'IT_PROG' AND salary < 5000;
SELECT * FROM employees WHERE NOT (job_id = 'IT_PROG' AND salary < 5000);

-- ��������01 : 2000���� 3000������ ������ �޴� ������� ��� ������ ��ȸ�غ�����
SELECT * FROM employees WHERE salary >= 2000 AND salary <= 3000;
SELECT * FROM employees WHERE salary BETWEEN 2000 AND 3000;

-- ��������02 : �μ���ȣ�� 30���̰ų� 60���̰ų� 90���� ������� ��� ������ ��ȸ�غ�����
SELECT 
    * 
FROM 
    employees 
WHERE 
    department_id = 30 OR 
    department_id = 60 OR
    department_id = 90;

-- ��������03 : �����ȣ�� ¦���� ����鸸 ��ȸ�غ�����
SELECT * FROM employees WHERE MOD(employee_id, 2) = 0;


-- COLUMN BETWEEN A AND B : �ش� �÷��� ���� A �̻� B �����϶� True
SELECT * FROM employees WHERE salary BETWEEN 2000 AND 3000;
SELECT * FROM employees WHERE hire_date BETWEEN '05/07/01' AND '05/12/31';

-- COLUMN IN (A, B, C ...) : ()���� ���뿡 �ش� ���� �����ϸ� true
SELECT * FROM employees WHERE department_id IN (30, 60, 90);
SELECT * FROM employees WHERE job_id IN ('PU_MAN', 'PU_CLERK', 'IT_PROG');
SELECT * FROM employees WHERE job_id NOT IN ('PU_MAN', 'PU_CLERK', 'IT_PROG');

-- ���ʽ� �ݾ��� NULL�� ��� ����� ��ȸ�غ���
SELECT * FROM employees WHERE commission_pct = NULL; -- �ƹ��͵� �ȳ���

-- ���� NULL�� ������ ���鶧�� IS NULL�� �̿��ؾ� �Ѵ� (NULL�� ũ�� �񱳰� �Ұ����ϴ�)
SELECT * FROM employees WHERE commission_pct IS NULL;
SELECT * FROM employees WHERE commission_pct IS NOT NULL;


-- LIKE 
/*
    - �������� �Ϻκ����� ���ϴ� ������ �˻��� �� �ִ� 
    - % : �ƹ� ���ڿ��̳� �͵� �Ǵ� �ڸ� (��� ��)
    - _ : �ϳ��� ���ڰ� �ݵ�� �;� �ϴ� �ڸ�     
*/

-- �ڵ��� ��ȣ�� 515.���� �����ϴ� ��� Ʃ���� ��ȸ
SELECT * FROM employees WHERE phone_number LIKE '515.%';

-- �ڵ��� ��ȣ�� .123.�� ���Ե� ��� Ʃ���� ��ȸ
SELECT * FROM employees WHERE phone_number LIKE '%.123.%';

-- LAST_NAME�� �� ��° ���ڰ� a�� ��� ���� ��ȸ
SELECT * FROM employees WHERE last_name LIKE '_a%';

-- LAST_NAME�� a�� �� �� �̻� ���Ե� ��� ���� ��ȸ
SELECT * FROM employees WHERE last_name LIKE '%a%a%';


-- ��������04 : LAST_NAME�� �ڿ��� �� ��° ���ڰ� a�� ��� ����� ��ȸ�غ�����

-- ��������05 : LAST_NAME�� 3��° ���ڰ� r�̰� �ڵ��� ��ȣ�� .�� 3�� ���Ե� 
--            ��� ����� ��ȸ�غ����� 











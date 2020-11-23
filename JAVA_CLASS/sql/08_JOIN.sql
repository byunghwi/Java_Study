-- 08_JOIN.sql

/*
    # �ĺ�Ű (Candidate key)
        - ���̺� ������ �� ���� �����ϰ� ������ �� �ִ� ��� �÷�
    # �⺻Ű (Primary key, PK)
        - �ĺ�Ű�� �߿��� ���̺��� Ű�� ���õ� �� 
        - �� ���̺� �� �⺻Ű�� �ϳ��ۿ� ������ �� ����
    # �ܷ�Ű (Foreign key, FK)
        - �ٸ� ���̺����� �⺻Ű(Ȥ�� �ĺ�Ű)������, 
          ���� ���̺����� �ߺ��Ǵ� ���� �÷�
          ex: employees ���̺��� job_id�� jobs ���̺����� �⺻Ű��
          ex2: employees ���̺��� department_id�� departments ���̺����� �⺻Ű��
        - �ܷ�Ű�� ������ ���̺����� ���谡 �����ȴ�
        
    # �ٸ� ���̺��� �⺻Ű�� ������ ����ϴ� ������
	  ���̺��� ���踦 �����Ѵ�

        ���		�μ���ȣ	����	��Ī 	�ϴ���
        A 10		10	����	���ߺ�	���α׷���
        B 10		20	...	...	...
        C 20		30
        D 10		40
        ....

	# ���̺��� ������ �������� �ߺ��� �ּ�ȭ �� �� �ִ� 

        ȸ��
    
        �̸�	�μ���ȣ	����	    ��Ī	    �ϴ���
        A	10	    ����	    ���ߺ�	���α׷���
        B	10	    ����	    ���ߺ�	���α׷���
        C	10      ����	    ���ߺ�	���α׷���   
        D	10      ����	    ���ߺ�	���α׷���

	�� ���̺��� ������ �⺻Ű�� �ܷ�Ű�� �����Ͽ� �� ���̺� ���� ������� �����Ѵ�        
*/
SELECT * FROM employees;
SELECT * FROM jobs;
SELECT * FROM departments;

/*
    # ���̺� JOIN
        - �⺻Ű�� �ܷ�Ű�� �̿��� ���谡 �����Ǿ� �ִ� ���̺���� 
          ������ �����Ͽ� ��ȸ�ϴ� �� 
    
    # CROSS JOIN
        - �� ���̺��� �����͸� �����Ͽ� ���� �� �ִ� ��� ��츦 ����� JOIN
        - �׳� ��� ��츦 ������ ������� ����
*/

-- �� ���̺��� ������ ��� ��찡 ��µȴ� (CROSS JOIN)
SELECT * FROM employees, departments; -- 2,889(107 * 27) rows 

SELECT * FROM employees; -- 107 rows
SELECT * FROM departments; -- 27 rows

/*
    # EQUI JOIN
        - �� ���̺� ���� ���� ������ ���� ���� �÷��� �̿��Ͽ� 
          CROSS JOIN�� ������� �ǹ��ִ� �����͸� �ɷ����� JOIN
*/
SELECT 
    last_name, department_name 
FROM 
    employees, departments 
WHERE 
    employees.department_id = departments.department_id
ORDER BY
    last_name ASC;

-- ��������01 : LAST_NAME�� Bloom�� ����� ������ �μ����� ��ȸ�غ����� 
SELECT
    employees.last_name, 
    departments.department_name
FROM
    employees, departments
WHERE
    employees.department_id = departments.department_id
    AND last_name = 'Bloom';

-- ��������02 : JOB_ID�� IT_PROG�� ������� LAST_NAME/�μ���ȣ/�μ����� ��ȸ�غ�����
SELECT 
    last_name, departments.department_id, department_name 
FROM 
    employees, departments 
WHERE 
    employees.department_id = departments.department_id 
    AND employees.job_id = 'IT_PROG';

-- ��������03 : �þ�Ʋ���� �ٹ��ϴ� ��� ����� �̸��� �޿��� ��ȸ�غ�����
SELECT 
    first_name, last_name, salary
FROM 
    employees, departments, locations
WHERE
    employees.department_id = departments.department_id
    AND departments.location_id = locations.location_id
    AND city='Seattle';

-- ��������04 : ��å�̸��� Marketing�� �� ��� ����� �̸��� �޿��� ������� ��ȸ�غ�����
SELECT
    last_name, salary, hire_date, job_title
FROM 
    employees, jobs
WHERE
    employees.job_id = jobs.job_id
    AND job_title LIKE '%Marketing%';
    
-- ���̺��� �����ϰ� �� �ɰ������� �ʿ��Ҷ� �ϳ��� ���̺�� ���ļ� ����� �� �ְ�
-- �����;��� ���� �� �ִ� (��� ��ȸ�� ����)

/*
    # SELF JOIN
        - �ϳ��� ���̺� ������ �ڽŰ� JOIN�Ͽ� ���ϴ� �����͸� ���� ��
        - MANAGER_ID�� employees ���̺��� �⺻Ű�� �� �� �ִ� �ܷ�Ű�̴�
*/

-- ���� �̸��� �ش� ������ ����ϴ� �Ŵ��� �̸��� ��ȸ
SELECT 
    a.first_name, a.last_name AS "���̸�", b.first_name, b.last_name AS "�Ŵ����̸�" 
FROM 
    employees a, employees b
WHERE
    a.manager_id = b.employee_id
ORDER BY 
    a.last_name ASC;
        
-- ��������05: �Ŵ����� King�� ������� �̸��� job_title�� ��ȸ�غ����� 
SELECT 
    a.last_name,
    job_title
FROM
    employees a, employees b, jobs
WHERE
    a.manager_id = b.employee_id 
    AND a.job_id = jobs.job_id
    AND b.last_name = 'King';

-- ��������06: Taylor�� ������ ��å�� ���� ����� ������ ��� ��ȸ�غ�����
SELECT
    a.*
FROM
    employees a, employees b
WHERE
    a.job_id = b.job_id
    AND b.last_name = 'Taylor';

/*
    # OUTER JOIN
        - JOIN ������ �������� ���ؼ� �������� ���� �����͵��� Ȯ���� �� ����ϴ� JOIN
        - �������� ���� ���� Ȯ���ϰ� �������� �ݴ��� ���ǿ� (+)�� ���δ�
        - (+)�� �������� �࿡ null�� �߰��Ͽ� �������� ���ߴ� ���� Ȯ���Ѵ�
*/
SELECT 
    * -- a.last_name as "�� �̸�", b.last_name as "�Ŵ��� �̸�" 
FROM
    employees a, employees b
WHERE
    a.manager_id(+) = b.employee_id
ORDER BY 
    a.last_name DESC;

-- ��������07: �����/�μ���ȣ/�μ��̸�/����ID�� ����ϵ� 
-- ����� �Ѹ� ������ ���� �μ��� �Բ� ��ȸ�غ����� 
SELECT 
    first_name, last_name, employees.department_id, department_name, location_id
FROM
    employees, departments
WHERE
    employees.department_id(+) = departments.department_id
ORDER BY
    first_name ASC;


-- ��������08: �����/����ID/���޸��� ����ϵ� 
-- ����� �Ѹ� ������ ���� ���޵� �Բ� ��ȸ�غ����� 
SELECT 
    first_name, last_name, employees.job_id, job_title
FROM
    employees, jobs
WHERE
    employees.job_id(+) = jobs.job_id;


-- ��������09: �μ���/�ּ�/���ø��� ����ϵ� �Ҽӵ� �μ��� ���� ���õ� �Բ� ��ȸ�غ�����
SELECT
    department_name, street_address, city
FROM
    departments d, locations l
WHERE
    d.location_id(+) = l.location_id;
    








-- 05_������ �Լ�.sql

/*
    # DUAL ���̺�
        - ��� �����ϴ� ���̺�
        - �ϳ��� �ุ ������ �ִ� �׽�Ʈ�� ���̺�
*/
SELECT 1 FROM dual;


-- ABS(n) : ���밪 
SELECT ABS(-99) FROM dual;

-- FLOOR(n) : ���� 
SELECT 3.55, FLOOR(3.55) FROM dual;

-- ROUND(n) : �ݿø�
SELECT 3.55, ROUND(3.55) FROM dual;

-- CEIL(n) : �ø�
SELECT 3.11, CEIL(3.11) FROM dual;

-- MOD(value, divider) : ������ ����
SELECT MOD(5, 3) FROM dual;

-- TRUNC(value, �ڸ�) : ������ �ڸ� �� ���ϸ� ������
SELECT TRUNC(1234.56789, 2) FROM dual;
SELECT TRUNC(1234.56789, -1) FROM dual;
SELECT TRUNC(1234.56789, -2) FROM dual;

-- TRUNC�� sysdate
SELECT sysdate FROM dual; -- sysdate : ���� ��¥ �� �ð��� �����ش�

-- TRUNC�� ������ Ÿ���� ������ �̿��Ѵ� 
SELECT TRUNC(sysdate, 'YEAR') FROM dual;
SELECT TRUNC(sysdate, 'MONTH') FROM dual;
SELECT TRUNC(sysdate, 'DAY') FROM dual;

-- LOWER
SELECT LOWER('ABC') FROM dual;
-- UPPER
SELECT UPPER('abc') FROM dual;

-- SUBSTR(str, start, numOfChar) : start���� �ش� ������ŭ�� ���ڸ� �ڸ���
SELECT SUBSTR('Hello world!', 5, 3) FROM dual; -- 1 base
SELECT SUBSTR('Hello world!', 6) FROM dual;

-- LENGTH
SELECT LENGTH('55555') FROM dual;

-- LPAD(����, ����, ä�﹮��)
-- RPAD(����, ����, ä�﹮��)
SELECT LPAD('MENU', 20, '#') FROM dual;
SELECT RPAD('MENU', 20, '#') FROM dual;

-- LTRIM(����, �����ҹ���)
-- RTRIM(����, �����ҹ���)
SELECT LTRIM('#######MENU', '#') FROM dual;
SELECT RTRIM('MENU#####', '#') FROM dual;

SELECT '        MENU', LTRIM('        MENU') FROM dual;
SELECT 'MENU        ', RTRIM('MENU       ') FROM dual;

-- TRIM() : �� ���� Ư�� ���ڸ� �����Ѵ� 
SELECT TRIM('#' FROM '#####MENU#####') FROM dual;


-- ��¥ �ٷ��
SELECT 
    sysdate - 1 as ����,
    sysdate as ����, 
    sysdate + 1 as ����, 
    sysdate + 2 as "���� ��" 
FROM dual;


-- ��¥ - ��¥
SELECT last_name, FLOOR((sysdate - hire_date) / 365) AS �ٹ��� FROM employees;

-- ��¥ ���� �����ϱ�
/*
    YYYY : �⵵
    YY : �⵵ (2�ڸ�)
    MM : ���� ���ڷ�
    MON : ���� ���ڷ�
    DD : ��¥    
    DAY : ����
    DY : ������ ���Ӹ���
    HH,HH12 : 12��
    HH24 : 24��     
    mm, mi : ��
    ss : ��    
    AM, PM: ���� ���� ǥ��
*/
SELECT 
    last_name, 
    TO_CHAR(hire_date, 'CC YYYY MONDD DY HH24:mi:ss PM') 
FROM 
    employees;

-- ROUND�� ��¥�� �Բ� �̿��ϱ� 
SELECT last_name, TRUNC(hire_date, 'MONTH') FROM employees;
SELECT last_name, TO_CHAR(ROUND(hire_date, 'MM'), 'CC YY-MM-DD HH:mm:ss') FROM employees;
SELECT last_name, hire_date FROM employees;

-- TRUNC�� ROUND�� ��¥ ������ ����� �� �ִ�
-- ����� ��¥ ���˰����� ���� �Ǵ� �ݿø��� �Ѵ�


-- MONTHS_BETWEEN : �� ��¥ ������ ���� ���� ���Ѵ�
SELECT MONTHS_BETWEEN(sysdate, hire_date) FROM employees;
SELECT TRUNC(MONTHS_BETWEEN(sysdate, hire_date)) FROM employees;
SELECT FLOOR(MONTHS_BETWEEN(sysdate, hire_date)) FROM employees;

-- ADD_MONTHS(date, num) : �ش� ��¥�� ������ ���� ���� �߰��Ѵ�
SELECT last_name, hire_date, ADD_MONTHS(hire_date, 6) FROM employees;

-- NEXT_DAY(date, ����) : �ش� ��¥�� �������� ���� ������ ��¥�� ã�´�
SELECT NEXT_DAY(sysdate, 'ȭ����') FROM dual;
SELECT NEXT_DAY(sysdate, '������') FROM dual;
SELECT NEXT_DAY(sysdate, '������') FROM dual;

-- LAST_DAY(date) : �ش� ��¥�� ���� ���� ������ ��¥�� ��ȯ�Ѵ�
SELECT LAST_DAY(sysdate) FROM dual;
SELECT LAST_DAY('2222/02/01') FROM dual;

-- �� ��ȯ �Լ���
/*
    Number   - TO_CHAR ->    Character   - TO_DATE ->    Date 
    Number   <- TO_NUMBER-   Character   <- TO_CHAR -    Date  
*/
-- ��¥�� ���ڷ� ��ȯ (������ ���� ��)
SELECT TO_CHAR(sysdate, 'YY/MM/DD HH:mi:ss day') FROM dual;

-- ���ڸ� ���ڷ� ��ȯ�� ���� ����
/*
    0 : �ڸ����� ��Ÿ����. ���ڰ� ��� 0���� ä���.
    9 : �ڸ����� ��Ÿ����. ���ڰ� ��� ��ĭ���� ä���.
    L : �� ������ ��ȭ ��ȣ�� ���δ�
    . : �Ҽ����� ����Ѵ�
    , : õ ������ �����ϴ� ��ǥ�� ���
*/
SELECT TO_CHAR(11112345, '00,000,000.00') FROM dual;
SELECT TO_CHAR(12345, '99999999') FROM dual;
SELECT last_name, TO_CHAR(salary, '99999L') FROM employees;

-- TO_DATE : ���ڸ� ��¥�� ��ȯ
SELECT TO_DATE('1999/05/24', 'YYYY/MM/DD') FROM dual;
SELECT TO_DATE('19990524', 'YYYYMMDD') FROM dual;

-- TO_NUMBER : ���ڸ� ���ڷ� ��ȯ
SELECT TO_NUMBER('123,455', '999,999') FROM dual;

-- NVL : NULL�� �ٸ������� ġȯ
SELECT NVL(null, 'other value') FROM dual;

SELECT last_name, NVL(commission_pct, 0.0) FROM employees;
SELECT last_name, 'CEO' AS manager_id FROM employees WHERE manager_id IS NULL;

-- DECODE() : switch case���� ������ �Ѵ�

SELECT * FROM employees;

SELECT 
    last_name as myname, 
    manager_id, 
    DECODE(manager_id, 
                        -- subquery : ������ ���ο� ���Ǵ� ����
                100, (SELECT last_name FROM employees WHERE employee_id = 100), 
                102, 'De Haan',
                103, (SELECT last_name FROM employees WHERE employee_id = 103)
    ) AS manager_name
FROM
    employees
WHERE
    manager_id IN (100, 102, 103);


select * from employees;
select * from jobs where job_id like '%CLERK';

-- ��������01: ���޿� ���� �޿��� �λ��ؼ� ����غ�����
--      IT_PROG : 15% �λ�
--      FI_ACCOUNT : 10% �λ�
--      ��� ������ CLERK : 20% �λ�

-- �� ������ �޿��� before_salary�� �λ�� �޿��� after_salary�� 
--   �޿��� ������ ����� �̸��� �Բ� ����� ��

-- FROM TABLE���� SELECT���� ���������� �� �� �ִ�
-- �� ������������ ���� �÷��� ��Ī�� �ٱ� SELECT�������� ����� �� �ִ�
SELECT * FROM (SELECT 
    last_name, 
    job_id, 
    salary as before_salary,
    DECODE(job_id, 
        'IT_PROG', salary * 1.15,
        'FI_ACCOUNT', salary * 1.1,
        'PU_CLERK', salary * 1.2,
        'ST_CLERK', salary * 1.2,
        'SH_CLERK', salary * 1.2) as after_salary
FROM
    employees)
WHERE 
    after_salary IS NOT NULL;

SELECT 
    last_name, 
    job_id, 
    salary as before_salary,
    DECODE(job_id, 
        'IT_PROG', salary * 1.15,
        'FI_ACCOUNT', salary * 1.1,
        'PU_CLERK', salary * 1.2,
        'ST_CLERK', salary * 1.2,
        'SH_CLERK', salary * 1.2) as after_salary
FROM
    employees
WHERE
    job_id IN ('IT_PROG', 'FI_ACCOUNT') OR
    job_id LIKE '%_CLERK';

-- UNION(������) �̿��ϱ�
SELECT 
    last_name, 
    job_id, 
    salary as before_salary, 
    salary * 1.15 as after_salary
FROM
    employees
WHERE
    job_id = 'IT_PROG'
UNION 
SELECT 
    last_name, 
    job_id, 
    salary, 
    salary * 1.1
FROM
    employees
WHERE
    job_id = 'FI_ACCOUNT'
UNION
SELECT 
    last_name, 
    job_id, 
    salary, 
    salary * 1.2
FROM
    employees
WHERE
    job_id LIKE '%_CLERK';


-- DECODE�� �ش� �÷��� ���� ��Ȯ�ϰ� ��ġ�ϴ� ���� �̿��� �� �ִٴ� ������ �ִ�
-- �׷� ���� CASE���� �̿��Ѵ�
SELECT * FROM (SELECT 
    last_name, job_id, salary as before_salary,
    CASE WHEN job_id = 'IT_PROG' THEN salary * 1.15
         WHEN job_id = 'FI_ACCOUNT' THEN salary * 1.1
         WHEN job_id LIKE '%_CLERK' THEN salary * 1.2
    END AS after_salary
FROM
    employees)
WHERE
    after_salary IS NOT NULL;









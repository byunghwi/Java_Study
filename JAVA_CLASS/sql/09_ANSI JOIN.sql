-- 09_ANSI JOIN.sql

-- ANSI(�̱� ���� ǥ�� ��ȸ)���� ���� ǥ���� ������ JOIN����

-- ANSI CROSS JOIN
SELECT
    *
FROM
         employees
    CROSS JOIN departments;

-- ANSI INNER JOIN : ���ǿ� �´� �ุ �����ϴ� JOIN
SELECT
    *
FROM
         employees e
    INNER JOIN departments d ON e.department_id = d.department_id;

/*
    ANSI OUTER JOIN : ���ǿ� �� �´� �൵ ������� �� ����ϴ� JOIN
    
        - LEFT OUTER JOIN : �����ʿ� (+)�� ���� ���� ����
        - RIGHT OUTER JOIN : ���ʿ� (+)�� ���� ���� ���� 
        - FULL OUTER JOIN : ���ʿ� (+)�� ���� ���� ���� 
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

-- ANSI JOIN�� �̿��� �� JOIN ���ǿ� �̿�Ǵ� �÷����� ���� ��� 
-- USING�� �̿��� �������� ����ȭ �� �� �ִ�
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

-- JOIN�� ���Ǵ� ���ǰ� �ʿ��ؼ� ����ϴ� ������ ���еȴ� 
-- USING�� ���� �÷��� ��� ���̺��� �÷����� ��Ȯ�� �� �ʿ䰡 ��������
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

-- ANSI JOIN�� �̿��Ͽ� Ǯ�����

-- ��������01: FIRST_NAME�� Neena�� ����� ���� ���ÿ��� �ٹ��ϴ� ��� ����� �̸��� �μ���ȣ�� ��ȸ�غ�����
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

-- ��������02: FIRST_NAME�� Neena�� ����� �޿����̰� 5õ ������ ��� ����� ��ȸ�غ�����
SELECT
    e1.*
FROM
         employees e1
    INNER JOIN employees e2 ON e2.first_name = 'Neena'
                               AND abs(e2.salary - e1.salary) <= 5000
ORDER BY
    e1.salary DESC;
                    -- e1.salary BETWEEN e2.salary - 5000 AND e2.salary + 5000;


-- ��������03: �þ�Ʋ���� �ٹ��ϴ� ��� ����� �̸�/�μ���/���ø� ��ȸ
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


-- ��������04: �Ŵ����� �̸��� King�� ��� ����� �̸�/��å��/������ ��ȸ
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
    
    

-- 11_���̺� ����.sql

/*
    # DML (Data Manipulation Language, ������ ���۾�)
        - ���̺� ������ �����͸� �˻�/�߰�/����/�����ϴ� ��ɾ�
        - SELECT : �˻�
        - INSERT : ����
        - UPDATE : ����
        - DELETE : ����
    
    # DDL (Data Definition Language, ������ ���Ǿ�)
        - ���̺� ��(������, �ε���, �� ...)�� ������ �����ϴµ� ����ϴ� ��ɾ� 
        - CREATE : ����
        - DROP : ����
        - ALTER : ����
        - TRUNCATE : ���� ���� 
        
    # DCL (Data Control Language, ������ ���� ��ɾ�)
        - ������� ������ �����ϴµ� ����ϴ� ��ɾ�
        - GRANT : ����ڿ��� ������ �ο�
        - REVOKE : ������� ������ ȸ��
*/

/*
    # ���̺� ����
        CREATE TABLE ���̺�� (�÷��̸�1 �÷�Ÿ��1, �÷��̸�2 �÷�Ÿ��2, ....);
*/
CREATE TABLE coffees (
    CID NUMBER(4),
    CNAME VARCHAR2(30),
    CPRICE NUMBER(6)
);

DESC coffees;

-- # ������ �����ϴ� ���̺��� �����ϸ鼭 ����� 
CREATE TABLE employees2 AS SELECT * FROM employees;
CREATE TABLE employees3 AS (SELECT last_name AS �̸�, salary AS ����, job_id AS ���� FROM employees);

-- # ���̺� �����ϱ� 
drop table coffees;
drop table employees2;

-- # ������ �˻�
show recyclebin;
select * from recyclebin;

-- # ������ �����ϱ�
FLASHBACK TABLE coffees TO BEFORE DROP;

-- # ������ ����
PURGE recyclebin;

-- # ������ ��ġ�� �ʰ� �ٷ� ���̺� ����
DROP TABLE coffees PURGE;
DROP TABLE employees3 PURGE;


-- ��������01: 50�� �μ� �����θ� ������ ���̺��� �ϳ� �����غ�����
CREATE TABLE dept50 AS SELECT * FROM employees WHERE department_id = 50;
DROP TABLE dept50 PURGE;


-- # ���̺��� ������ �����ϱ� (�Ϻη� ���� �ȵǴ� ������ �ְ� ���̺� ����)
CREATE TABLE employeee AS SELECT * FROM employees WHERE 1 = 0;
DESC employeee;
DROP TABLE employeee PURGE;


-- # ���̺� ���� ���� ��ɾ�� 
CREATE TABLE coffees (
    CID NUMBER(4),
    CNAME VARCHAR2(30),
    CPRICE NUMBER(6)
);

-- # ALTER TABLE ���̺�� ADD (�÷���1 �÷�Ÿ��1, �÷���2 �÷�Ÿ��2, ...)
ALTER TABLE coffees ADD (
    location_id NUMBER(4),
    acidity NUMBER(4, 2)
);
DESC coffees;

-- # ALTER TABLE ���̺�� MODIFY (�÷��� �÷�Ÿ��, ...)
--   - �÷��� ������ ���� ������ Ÿ���̳� ũ�� ���� ������ �� �ִ�
--   - �÷����� ������ �� ����
ALTER TABLE coffees MODIFY (
    cid number(3),
    cname varchar2(50)
);
DESC coffees;

-- # ALTER TABLE ���̺�� DROP COLUMN �÷���;
ALTER TABLE coffees DROP COLUMN acidity;
DESC coffees;

-- # ALTER TABLE ���̺�� SET UNUSED(�÷���) : ������ �غ� ��Ű�� (SET UNUSED)
--  - �ش� �÷��� �����ϱ� ���� ������� ���ϴ� ���·� �����Ѵ� 
--  - �������� ������ ���߿� ������ �� ����Ѵ�
--  - ���̺� ����� ���� ���� �� ������ �ð��� �����ϱ� ���� �����Ѵ�
ALTER TABLE coffees SET UNUSED(location_id);
DESC coffees;

-- ������ �ð��뿡 ������ �����Ѵ�
ALTER TABLE coffees DROP UNUSED COLUMNS;


-- # ���̺�� �����ϱ�
RENAME coffees TO coffee_shop;

-- # �÷��� �����ϱ�
ALTER TABLE coffee_shop RENAME COLUMN cid TO cfid;
DESC coffee_shop;

/*
    # ������ ��ųʸ�
        - �츮�� ���̺��� �߰��ϸ� DB�� �����ϴ� ���̺��� ������ DBMS�� �˾Ƽ� �����Ѵ�
        - ��ó�� ����ڰ� ���� �����ϴ� ���� �ƴ� �����͵��� ������ ��ųʸ���� �θ���
        
    # ������ ��ųʸ� �� 
        - ������ ��ųʸ��� ����ڰ� ���� ���ϵ��� ��ȯ�Ͽ� �����ϴ� ��(View)    
*/

-- # ���̺� ������ ��ųʸ� ��
SELECT * FROM tab;
SELECT * FROM tabs;
SELECT * FROM user_tables; -- USER_ : ���� USER�� ������ �ִ� ������ �����ִ� ������ ��ųʸ� ��
SELECT * FROM all_tables;  -- ALL_  : ��� USER�� ������ �ִ� ������ �����ִ� ������ ��ųʸ� ��

-- # ��������(constraints) ������ ��ųʸ� ��
SELECT * FROM user_constraints;
SELECT * FROM all_constraints;

SHOW USER;








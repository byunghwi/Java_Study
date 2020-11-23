-- 17_인덱스.sql

/*
    # 인덱스 (Index)
        - 테이블 내의 빠른 검색을 위해 사용한다 
        - 책 맨뒤에 ㄱ,ㄴ,ㄷ순으로 정렬해놓은 색인과 비슷한 개념이다 
        - 새로운 데이터(행)가 추가되면 색인(인덱스)을 다시 생성해야 한다
        - 데이터의 추가/수정/삭제가 빈번한 테이블에서는 인덱스를 최소화 하는것이 유리하다
        - 반면에, 추가/수정/삭제가 드물고 검색이 빈번한 테이블에서는 인덱스를 생성하는 것이 유리하다
        - 인덱스가 있는 컬럼과 없는 컬럼의 검색 속도(쿼리문 처리 속도)가 확연히 다르다 
    
    # 인덱스의 장점
        - 검색 속도가 빨라진다
        - 적절한 인덱스 사용은 시스템 전체 성능을 향상시킨다
    
    # 인덱스의 단점
        - 인덱스를 위한 추가 공간이 필요하다 
        - 인덱스를 생성하는데 시간이 걸린다
        - 추가/수정/삭제가 빈번한 경우에는 오히려 성능이 저하된다
        
    # 기본키(PK) 또는 유일키(UNIQUE) 제약조건을 지정한 컬럼에는 자동으로 인덱스가 생성된다 
        - 이렇게 등록되는 인덱스들은 제약조건 이름으로 인덱스가 등록되어 있다
*/

-- 인덱스 데이터 딕셔너리 뷰 
SELECT * FROM user_ind_columns;
SELECT * FROM all_ind_columns;

SELECT * FROM user_ind_columns WHERE table_name = 'EMP3';

-- 테이블 내용 복사하기
INSERT INTO emp3 SELECT * FROM emp3 WHERE last_name <> '둘리';
SELECT COUNT(*) FROM emp3;

desc emp3;

-- 검색용으로 사용할 행을 하나 추가
INSERT INTO emp3(last_name, email, hire_date, job_id) VALUES('둘리', 'DOOLY', sysdate, '백수');

-- 수행시간 표시/비표시
SET TIMING ON;
SET TIMING OFF;

-- 인덱스 생성 전 : 0.170, 인덱스 생성 후 : 
SELECT last_name, email FROM emp3 WHERE last_name = '둘리'; 
SELECT last_name, email FROM emp3 WHERE email = 'DOOLY'; 

SELECT DISTINCT last_name, email FROM emp3 WHERE last_name = '둘리';


/*
    CREATE INDEX 인덱스명 ON 테이블명(컬럼명);
*/
CREATE INDEX emp3_lname_ix ON emp3(last_name);

/*
    # 인덱스를 사용해야 하는 경우
        - 테이블에 행의 수가 많을 때
        - 해당 컬럼이 WHERE절의 조건으로 자주 사용될 때
        - 검색 결과가 전체 데이터의 5% 미만일 때
        - JOIN에 자주 사용되는 컬럼일 때 
    
    # 인덱스를 사용하지 말아야 하는 경우
        - 테이블에 행의 수가 적을 때
        - WHERE절에 해당 컬럼이 자주 사용되지 않을 때
        - 검색 결과가 전체 데이터의 15% 이상일 때 
        - 해당 테이블에 DML작업이 많을 때 (추가/수정/삭제)
*/









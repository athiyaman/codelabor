DROP TABLE EXAMPLE_EMP;

CREATE TABLE EXAMPLE_EMP
(
	EMPNO 	INT PRIMARY KEY NOT NULL,
	ENAME 	VARCHAR(10),
	JOB 	VARCHAR(9),
	MGR 	INT,
	HIREDATE TIMESTAMP,
	SAL 	DEC(7,2),
	COMM 	DEC(7,2),
	DEPTNO 	INT
);

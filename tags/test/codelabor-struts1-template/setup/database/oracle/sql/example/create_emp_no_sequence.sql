DROP SEQUENCE EXAMPLE_EMP_NO_SEQUENCE;

CREATE SEQUENCE EXAMPLE_EMP_NO_SEQUENCE
	START WITH 8000
	MAXVALUE 999999999
	MINVALUE 0
	NOCYCLE
	CACHE 20
	NOORDER;

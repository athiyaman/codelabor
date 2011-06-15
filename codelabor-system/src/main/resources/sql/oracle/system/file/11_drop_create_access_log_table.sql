DROP TABLE ACCESS_LOG PURGE;

CREATE TABLE ACCESS_LOG (
	SEQ			NUMBER(27, 0),
	USER_ID		VARCHAR2(32),
	RESOURCE_ID	VARCHAR2(32),
	MESSAGE		VARCHAR2(1024),
	IP_ADDRESS	VARCHAR2(16),
	TIMESTAMP	DATE DEFAULT SYSDATE,
	PRIMARY KEY ("SEQ") ENABLE
);
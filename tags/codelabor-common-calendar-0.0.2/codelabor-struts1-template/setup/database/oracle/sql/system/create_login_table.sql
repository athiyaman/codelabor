DROP TABLE LOGIN;

CREATE TABLE LOGIN (
	SESSION_ID	VARCHAR2(64),
	USER_ID		VARCHAR2(32),
	IP_ADDRESS	VARCHAR2(16),
	LOGIN_TIMESTAMP	DATE DEFAULT SYSDATE,
	LOGOUT_TIMESTAMP DATE,	
	PRIMARY KEY ("SESSION_ID") ENABLE
);
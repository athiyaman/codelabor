DROP TABLE PERSISTENT_LOGINS PURGE;

CREATE TABLE PERSISTENT_LOGINS (
	USERNAME varchar(64) NOT NULL,
	SERIES varchar(64) PRIMARY KEY,
	TOKEN varchar(64) NOT NULL,
	LAST_USED TIMESTAMP NOT NULL
);

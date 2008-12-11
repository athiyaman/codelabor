DROP TABLE FILE_REPOSITORY ;

CREATE TABLE FILE_REPOSITORY
(
	FILE_ID				BIGINT PRIMARY KEY NOT NULL,
	REAL_FILE_NAME	 	VARCHAR(512),	
	UNIQUE_FILE_NAME	VARCHAR(512),
	REPOSITORY_PATH		VARCHAR(512),
	CONTENT_TYPE		VARCHAR(64),
	FILE_SIZE			BIGINT,
	BLOB_DATA 			BLOB
);



create table persistent_logins 
(
   username  VARCHAR2(64)  not null,
   series  VARCHAR2(64)  primary key,
   token  VARCHAR2(64)  not null,
   last_used  TIMESTAMP  not null
);

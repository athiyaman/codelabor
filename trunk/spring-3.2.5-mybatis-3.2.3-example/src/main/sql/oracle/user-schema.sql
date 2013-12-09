 create table users 
(
   username  VARCHAR2(50)  not null primary key,
   password  VARCHAR2(50)  not null,
   enabled  NUMBER(1,0)  not null
);
create table authorities 
(
   username  VARCHAR2(50)  not null,
   authority  VARCHAR2(50)  not null,
   foreign key(username) references users(username),
   unique(username,authority)
);




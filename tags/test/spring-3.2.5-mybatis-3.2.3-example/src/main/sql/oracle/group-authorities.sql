create table groups 
(
   id  NUMBER(20,0)  not null  primary key CHECK(id >= 0),
   group_name  VARCHAR2(50)  not null
);
DROP SEQUENCE SWS_groups_ID;
CREATE SEQUENCE SWS_groups_ID INCREMENT BY 1 START WITH 1;
CREATE OR REPLACE TRIGGER SWT_groups_ID
BEFORE INSERT ON groups
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
WHEN(NEW.id IS NULL)
BEGIN
   SELECT SWS_groups_ID.NEXTVAL INTO :NEW.id FROM DUAL;
END;
/
create table group_authorities 
(
   group_id  NUMBER(20,0)  not null CHECK(group_id >= 0),
   authority  VARCHAR2(50)  not null,
   foreign key(group_id) references groups(id)
);
create table group_members 
(
   id  NUMBER(20,0)  not null  primary key CHECK(id >= 0),
   username  VARCHAR2(50)  not null,
   group_id  NUMBER(20,0)  not null CHECK(group_id >= 0),
   foreign key(group_id) references groups(id)
);
DROP SEQUENCE SWS_group_members_ID;
CREATE SEQUENCE SWS_group_members_ID INCREMENT BY 1 START WITH 1;
CREATE OR REPLACE TRIGGER SWT_group_members_ID
BEFORE INSERT ON group_members
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
WHEN(NEW.id IS NULL)
BEGIN
   SELECT SWS_group_members_ID.NEXTVAL INTO :NEW.id FROM DUAL;
END;
/

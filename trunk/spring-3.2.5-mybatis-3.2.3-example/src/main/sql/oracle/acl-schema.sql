create table acl_sid 
(
   id  NUMBER(20,0)  not null  primary key CHECK(id >= 0),
   principal  NUMBER(3,0)  not null,
   sid  VARCHAR2(100)  not null,
   unique(sid,principal)
);
DROP SEQUENCE SWS_acl_sid_ID;
CREATE SEQUENCE SWS_acl_sid_ID INCREMENT BY 1 START WITH 1;
CREATE OR REPLACE TRIGGER SWT_acl_sid_ID
BEFORE INSERT ON acl_sid
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
WHEN(NEW.id IS NULL)
BEGIN
   SELECT SWS_acl_sid_ID.NEXTVAL INTO :NEW.id FROM DUAL;
END;
/
create table acl_class 
(
   id  NUMBER(20,0)  not null  primary key CHECK(id >= 0),
   class  VARCHAR2(100)  unique not null
);
DROP SEQUENCE SWS_acl_class_ID;
CREATE SEQUENCE SWS_acl_class_ID INCREMENT BY 1 START WITH 1;
CREATE OR REPLACE TRIGGER SWT_acl_class_ID
BEFORE INSERT ON acl_class
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
WHEN(NEW.id IS NULL)
BEGIN
   SELECT SWS_acl_class_ID.NEXTVAL INTO :NEW.id FROM DUAL;
END;
/

create table acl_object_identity 
(
   id  NUMBER(20,0)  not null  primary key CHECK(id >= 0),
   object_id_class  NUMBER(20,0)  not null CHECK(object_id_class >= 0),
   object_id_identity  NUMBER(20,0)  not null CHECK(object_id_identity >= 0),
   parent_object  NUMBER(20,0)   CHECK(parent_object >= 0),
   owner_sid  NUMBER(20,0)   CHECK(owner_sid >= 0),
   entries_inheriting  NUMBER(3,0)  not null,
   unique(object_id_class,object_id_identity),
   foreign key(object_id_class) references acl_class(id),
   foreign key(parent_object) references acl_object_identity(id),
   foreign key(owner_sid) references acl_sid(id)
);
DROP SEQUENCE SWS_acl_object_identity_ID;
CREATE SEQUENCE SWS_acl_object_identity_ID INCREMENT BY 1 START WITH 1;
CREATE OR REPLACE TRIGGER SWT_acl_object_identity_ID
BEFORE INSERT ON acl_object_identity
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
WHEN(NEW.id IS NULL)
BEGIN
   SELECT SWS_acl_object_identity_ID.NEXTVAL INTO :NEW.id FROM DUAL;
END;
/
create table acl_entry 
(
   id  NUMBER(20,0)  not null  primary key CHECK(id >= 0),
   acl_object_identity  NUMBER(20,0)  not null CHECK(acl_object_identity >= 0),
   ace_order  NUMBER(10,0)  not null CHECK(ace_order >= 0),
   sid  NUMBER(20,0)  not null CHECK(sid >= 0),
   mask  NUMBER(10,0)  not null,
   granting  NUMBER(3,0)  not null,
   audit_success  NUMBER(3,0)  not null,
   audit_failure  NUMBER(3,0)  not null,
   unique(acl_object_identity,ace_order),
   foreign key(acl_object_identity)
   references acl_object_identity(id),
   foreign key(sid) references acl_sid(id)
);
DROP SEQUENCE SWS_acl_entry_ID;
CREATE SEQUENCE SWS_acl_entry_ID INCREMENT BY 1 START WITH 1;
CREATE OR REPLACE TRIGGER SWT_acl_entry_ID
BEFORE INSERT ON acl_entry
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
WHEN(NEW.id IS NULL)
BEGIN
   SELECT SWS_acl_entry_ID.NEXTVAL INTO :NEW.id FROM DUAL;
END;
/






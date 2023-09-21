drop table if exists lifung_user CASCADE;
drop table if exists task CASCADE ;
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;
create table lifung_user (id bigint not null, user_name varchar(255), primary key (id));
create table task (id bigint not null, description varchar(255), task_status integer, user_id bigint, primary key (id));
alter table task add constraint FKc0lebefnem9q2l093yjk7getp foreign key (user_id) references lifung_user;
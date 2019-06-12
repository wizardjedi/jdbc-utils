create table table1 (
  id bigint auto_increment,
  text varchar(10),
  create_date timestamp,
  primary key (id)
);


insert into table1 (text, create_date) values ('It works', now());

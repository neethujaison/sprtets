use cargo;
show tables;
create table tbl_user(
user_id int auto_increment primary key,
user_name varchar(30),
user_contactno varchar(30),
user_username varchar(30),
user_password varchar(30),
user_status varchar(30)
)
show tables;
create table tbl_uploadfile(
file_id int auto_increment primary key,
file_data longblob,
file_name varchar(100)
);
select * from tbl_uploadfile;

create table tbl_customer(
customer_id int auto_increment primary key,
customer_name varchar(30),
customer_address varchar(30),
country_id int,
city_id int,  
customer_phoneno varchar(20),
customer_email varchar(20),
customer_dob date,
doctype_id int,
document_no varchar(20),
document_country_id int,
national_id varchar(20),
customer_status varchar(20)
);
create table tbl_country(
country_id int auto_increment primary key,
country_name varchar(30)
);
create table tbl_city(
city_id int auto_increment primary key,
city_name varchar(30)
);
alter table tbl_city
add column country_id int;
create table tbl_doctype(
doctype_id int auto_increment primary key,
doctype_name varchar(30)
);
select * from tbl_city;
insert into tbl_country values(111,'UAE');
insert into tbl_country values(222,'India');
insert into tbl_country values(333,'US');
insert into tbl_country values(444,'Oman');

insert into tbl_city values(121,'Kerala');
insert into tbl_city values(122,'Dubai');
insert into tbl_city values(123,'Abudhabi');
insert into tbl_city values(124,'Muscat');
insert into tbl_city values(125,'Salala');
insert into tbl_city values(126,'Arizona');
insert into tbl_city values(127,'Seattle');


insert into tbl_doctype values(12,'File');
insert into tbl_doctype values(13,'Image');
insert into tbl_doctype values(14,'JPEg');
create database hibernatemapping;

use hibernatemapping;

create table person(
id int auto_increment primary key,
name varchar(20)
);

create table address(
id int auto_increment primary key,
street varchar(20),
city varchar(20),
person_id int,
foreign key(person_id) references person(id)
);


create table phone(
id int auto_increment primary key,
number varchar(20),
person_id int,
foreign key(person_id) references person(id)

);


create table project(
 id int auto_increment primary key,
 name varchar(20)
);

create table person_project(
person_id int,
project_id int,
primary key(person_id,project_id),
foreign key(person_id) references person(id),
foreign key(project_id) references project(id)

);


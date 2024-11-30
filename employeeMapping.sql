use employeemapping;

create table employee(
id int auto_increment primary key,
name varchar(20)
);

create table department(
id int auto_increment primary key,
name varchar(20),
employee_id int,
foreign key(employee_id) references employee(id)
);

create table phone(
id int auto_increment primary key,
name varchar(20),
employee_id int,
foreign key(employee_id) references employee(id)
);


create table project(
id int auto_increment primary key,
name varchar(20)
);


create table employee_project(
employee_id int,
project_id int,
primary key(employee_id,project_id),
foreign key(employee_id) references employee(id),
foreign key(project_id) references project(id)
);project
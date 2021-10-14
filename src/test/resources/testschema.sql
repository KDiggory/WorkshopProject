
drop table if exists projects CASCADE;
drop table if exists workshop CASCADE;
drop table if exists powertools CASCADE;

create table workshop
 (
 	id integer primary key auto_increment,
 	name varchar(255),
 	address varchar(255)
 	
 );
 

create table projects
 (
 	id integer primary key auto_increment,
 	days integer,
 	easy varchar(255),
 	materials varchar(255),
 	name varchar(255),
 	workshop_id integer,
 	foreign key (workshop_id) References workshop(id) on delete cascade
 	
 );
 
 create table powertools
 (
 	id integer primary key auto_increment,
 	name varchar(255),
 	usedFor varchar(255),
 	easy varchar(255),
 	cost integer,
 	dangerous varchar(255), 	
 	workshop_id integer,
 	project_id integer,
 	foreign key (workshop_id) References workshop(id) on delete cascade,
 	foreign key (project_id) References projects(id) on delete cascade
 	
 );

drop table if exists projects CASCADE;
drop table if exists workshop CASCADE;

create table workshop
 (
 	id integer primary key auto_increment,
 	workshopName varchar(255),
 	workshopAddress varchar(255)
 	
 );
 

create table projects
 (
 	id integer primary key auto_increment,
 	days integer,
 	easy boolean,
 	project_materials varchar(255),
 	project_name varchar(255),
 	FK_workshopId integer,
 	foreign key (FK_workshopId) References workshop(id) on delete cascade
 	
 );
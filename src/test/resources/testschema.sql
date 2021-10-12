
drop table if exists projects CASCADE;
drop table if exists workshop CASCADE;

create table workshop
 (
 	workshop_id integer primary key auto_increment,
 	workshop_name varchar(255),
 	workshop_address varchar(255)
 	
 );
 

create table projects
 (
 	project_id integer primary key auto_increment,
 	days integer,
 	easy varchar(255),
 	project_materials varchar(255),
 	project_name varchar(255),
 	FK_workshop_id integer,
 	foreign key (FK_workshop_id) References workshop(workshop_id) on delete cascade
 	
 );
drop database if exists CacaRobos;
create database if not exists CacaRobos;
use CacaRobos;

drop table if exists login;
create table if not exists login(
	id int primary key auto_increment,
    username varchar(50) unique not null,
    passcode varchar(64) not null,
    userType char(3) not null
);
INSERT INTO login (username, passcode, userType) VALUES ('admin@admin.com','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','ADM');

drop table if exists user;
create table if not exists user(
	id int primary key auto_increment,
    nickname varchar(50) unique not null,
    loginId int not null,
    foreign key (loginId) references login(id) on delete cascade,
    profilePicture mediumblob
);

drop table if exists manager;
create table if not exists manager(
	id int primary key auto_increment,
    name varchar(150) not null,
    cpf varchar(14) unique not null,
    loginId int not null,
    foreign key (loginId) references login(id) on delete cascade,
    profilePicture mediumblob
);
INSERT INTO manager (name, cpf, loginId) VALUES ('Admin','000.000.000-00',1);

drop table if exists valuer;
create table if not exists valuer(
	id int primary key auto_increment,
    name varchar(50) not null,
    cpf varchar(14) unique not null,
    loginId int not null,
    foreign key (loginId) references login(id) on delete cascade,
    activeAccount boolean null default 0,
    profilePicture mediumblob,
    reason varchar(255)
);

drop table if exists report;
create table if not exists report(
	id int primary key auto_increment,
    link varchar(255) unique not null,
    status varchar(30) not null,
    description varchar(255),
    userId int not null,
    foreign key (userId) references user(id),
    valuerId int,
    foreign key (valuerId) references valuer(id),
    dateReport datetime null default now(),
    activeReport boolean null default 1,
    isARobotVotes int null default 0,
    isNotARobotVotes int null default 0,
    trackingCode varchar(20) unique,
    socialNetworkType varchar(35) not null,
    title varchar(35) not null
);

drop table if exists activeReportTime;
create table if not exists activeReportTime(
    timeAvaliable int
);
insert into activeReportTime(timeAvaliable) value(7);

drop event if exists deactivateReport;
create event if not exists deactivateReport
	on schedule every 1 day
		starts '2017-09-13 09:00:00'
			do
				update report set activeReport=0, status='Finalizada'
					where datediff(now(),dataAdd)>=(select timeAvaliable from activeReportTime);

drop table if exists commentary;
create table if not exists commentary(
	id int primary key auto_increment,
    description varchar(255) not null, 
    userId int null,
    foreign key (userId) references user(id),
    valuerId int null,
    foreign key (valuerId) references valuer(id),
    userType char(3),
    reportId int not null,
    foreign key (reportId) references report(id) on delete cascade
);

drop table if exists votes;
create table if not exists votes(
	id int primary key auto_increment,
    reportId int not null,
    foreign key (reportId) references report(id),
    valuerId int not null,
    foreign key (valuerId) references valuer(id)
);
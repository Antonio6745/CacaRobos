drop database if exists CacaRobos;
create database if not exists CacaRobos;
use CacaRobos;

drop table if exists login;
create table if not exists login(
	id int primary key auto_increment,
    username varchar(50) unique not null,
    passcode varchar(32) not null,
    userType char(3) not null
);

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
    status varchar(30) not null,
    description varchar(255),
    userId int not null,
    foreign key (userId) references user(id),
    valuerId int,
    foreign key (valuerId) references valuer(id),
    approveReport boolean null default 0,
    dateReport datetime null default now(),
    activeReport boolean null default 1,
    isARobotVotes int,
    isNotARobot int
);

drop event if exists deactivateReport;
create event if not exists deactivateReport
	on schedule every 1 day
		starts '2017-09-13 09:00:00'
			do
				update report set activeReport=0
					where datediff(now(),dataAdd)>=7;

drop table if exists commentary;
create table if not exists commentary(
	id int primary key auto_increment,
    description varchar(255) not null, 
    userId int not null,
    foreign key (userId) references user(id),
    reportId int not null,
    foreign key (reportId) references report(id)
);
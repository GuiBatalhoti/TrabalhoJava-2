CREATE DATABASE DataFuck;

use DataFuck;

CREATE TABLE users(
	user_name varchar(256) PRIMARY KEY,
	email varchar(256) not null,
	passwd varchar(256) not null
);

CREATE TABLE manga(
	id_manga int UNIQUE PRIMARY KEY auto_increment,
	title varchar(256),
	author varchar(256),
	publication_date date
);

CREATE TABLE list(
	id_list int UNIQUE auto_increment,
	user_name varchar(256) not null,
	primary key(id_list, user_name),
	FOREIGN KEY (user_name) REFERENCES users (user_name)
);

CREATE TABLE manga_list(
	id_list int not null,
	id_manga int not null,
	foreign key (id_list) references list (id_list),
	foreign key (id_manga) references manga (id_manga),
	primary key(id_list, id_manga),
	description varchar(512),
	due date
);

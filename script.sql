drop database datafuck;
CREATE DATABASE DataFuck;

use DataFuck;

CREATE TABLE users(
	id_user int UNIQUE PRIMARY KEY auto_increment,
	user_name varchar(256),
	email varchar(256) not null,
	passwd varchar(256) not null
);

CREATE TABLE manga(
	id_manga int UNIQUE PRIMARY KEY auto_increment,
	title varchar(256),
	author varchar(256),
	publication_date date,
	num_chapter int
);

CREATE TABLE manga_list(
	id_user int not null,
	id_manga int not null,
	foreign key (id_user) references users (id_user),
	foreign key (id_manga) references manga (id_manga),
	primary key(id_user, id_manga),
	description varchar(512),
	due date
);

select * from users;


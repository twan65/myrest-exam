SET CHARACTER SET utf8mb4;
USE mydb;

insert into role(name) values ('ROLE_USER');
insert into user(username, password, enabled) values ('twan', '$2a$10$umNE0V5qWwH7SIFUeJlsn.57qLxBmFVPacSIPUtyWRu4pdKi8ibfu', true);
insert into role(user_id, role_id) values (1, 1);
insert into board(title, content, user_id) values ('title1', 'content1', 1);
insert into board(title, content, user_id) values ('title2', 'content2', 1);

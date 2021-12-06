CREATE DATABASE mydb CHARACTER SET utf8mb4;
CREATE USER 'myadmin'@localhost IDENTIFIED BY 'myadminpass';
GRANT ALL ON mydb.* TO 'myadmin'@'localhost';
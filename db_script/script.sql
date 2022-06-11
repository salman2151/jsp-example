CREATE DATABASE blog_app_database;
USE blog_app_database;

CREATE TABLE `user` (
id int NOT NULL AUTO_INCREMENT,
 first_name varchar(45) NOT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(100) NOT NULL,
  password varchar(100) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `blog_app_database`.`user` (`first_name`, `last_name`,`email`,`password`) VALUES ("Shehryar", "Ali","shery@gmail.com","qwe123");

select * from user

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

CREATE TABLE blog (
id int NOT NULL AUTO_INCREMENT,
category_id_fk int NOT NULL ,
 title varchar(200) NOT NULL,
  description varchar(10000) DEFAULT NULL,
  created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (category_id_fk)
      REFERENCES category( id)
      ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



INSERT INTO blog (`category_id_fk`, `title`,`description`) VALUES (17, "TitleOp","DescriptionOP");
CREATE TABLE category (
id int NOT NULL AUTO_INCREMENT,
 name varchar(200) NOT NULL,
  created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

select * from category;
	
SELECT blog.id, blog.title,blog.description,blog.created_on, category.id as category_id, category.name as category_name FROM blog,category WHERE category.id=blog.category_id_fk and blog.id = 7;

SELECT * FROM (SELECT blog.id, blog.title,blog.description,blog.created_on, category.id as category_id, category.name as category_name FROM blog,category WHERE category.id=blog.category_id_fk ORDER BY blog.id DESC LIMIT 3) t ORDER BY id DESC;


CREATE TABLE comment (
id int NOT NULL AUTO_INCREMENT,
blog_id_fk int NOT NULL ,
commenter varchar(200) NOT NULL,
  comment varchar(10000) DEFAULT NULL,
  created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (blog_id_fk)
      REFERENCES blog( id)
      ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



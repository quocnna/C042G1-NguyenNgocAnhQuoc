CREATE TABLE users(
   user_id INT AUTO_INCREMENT PRIMARY KEY,
   username VARCHAR(40),
   password VARCHAR(255),
   email VARCHAR(255)
);

CREATE TABLE roles(
   role_id INT AUTO_INCREMENT,
   role_name VARCHAR(50),
   PRIMARY KEY(role_id)
);

/* khoa chinh to hop */
CREATE TABLE userroles(
   user_id INT NOT NULL,
   role_id INT NOT NULL,
   PRIMARY KEY(user_id,role_id),
   FOREIGN KEY(user_id) REFERENCES users(user_id),
   FOREIGN KEY(role_id) REFERENCES roles(role_id)
);

create table if not exists test_table(
id int,
name varchar(50),
email varchar(50)
);

ALTER TABLE test_table
    ADD PRIMARY KEY(id);
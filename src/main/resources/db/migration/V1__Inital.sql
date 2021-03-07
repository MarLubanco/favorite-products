CREATE TABLE client(
   id int(7),
   name VARCHAR (50),
   email VARCHAR (50) UNIQUE,
   PRIMARY KEY(id)
);

CREATE TABLE product(
   id int(9),
   title varchar(60),
   image varchar(300),
   price bigint(10),
   id_magalu varchar(150),
   client_id int(7)
   PRIMARY KEY(id)
);
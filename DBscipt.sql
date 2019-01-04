CREATE TABLE users ( username varchar(50) NOT NULL,
password varchar(50) NOT NULL,
enabled NUMBER(1, 0) NOT NULL,
primary key (username)
)


INSERT INTO users VALUES ('john','{noop}test123',1);
INSERT INTO users VALUES ('mary','{noop}test123',1);
INSERT INTO users VALUES ('susan','{noop}test123',1);


Create table authorities(
username varchar2(50) NOT NULL,
authority varchar2(50) NOT NULL,
CONSTRAINT authorities_idx_1 UNIQUE (username,authority),
Constraint authorities_ibfk_1 FOREIGN KEY (username)
References users ( username)
);

INSERT INTO authorities VALUES ('john','ROLE_EMPLOYEE');
INSERT INTO authorities VALUES ('mary','ROLE_EMPLOYEE');
INSERT INTO authorities VALUES ('mary','ROLE_MANAGER');
INSERT INTO authorities VALUES ('susan','ROLE_ADMIN');
INSERT INTO authorities VALUES ('susan','ROLE_EMPLOYEE');

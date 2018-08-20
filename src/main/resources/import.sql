DROP TABLE IF EXISTS snippet;

CREATE TABLE snippet (
  id      VARCHAR(16) PRIMARY KEY ,
  note    VARCHAR(64),
  templateId   VARCHAR(24),
  data VARCHAR(64),
  groupname VARCHAR(24),
  yesAnswers NUMBER,
  neutralAnswers NUMBER,
  noAnswers NUMBER,
  createdtime TIMESTAMP default now()
);

DROP TABLE IF EXISTS app_role;
CREATE TABLE app_role (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  description varchar(255) DEFAULT NULL,
  role_name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS app_user;
CREATE TABLE app_user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  username varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role (
  user_id bigint(20) NOT NULL,
  role_id bigint(20) NOT NULL,
  CONSTRAINT FK859n2jvi8ivhui0rl0esws6o FOREIGN KEY (user_id) REFERENCES app_user (id),
  CONSTRAINT FKa68196081fvovjhkek5m97n3y FOREIGN KEY (role_id) REFERENCES app_role (id)
);


INSERT INTO snippet (id, note, templateId,data,groupname,yesAnswers, neutralAnswers, noAnswers)
VALUES ('1', 'Howto infrastructure page', 1,'Was this page useful?','default',1,2,3);

INSERT INTO snippet  (id, note, templateId,data,groupname,yesAnswers, neutralAnswers, noAnswers)
VALUES ('2', 'Training page about something ', 1,'Did you find this page useful?','default',4,5,6);

INSERT INTO snippet  (id, note, templateId,data,groupname,yesAnswers, neutralAnswers, noAnswers)
VALUES ('3', 'java position and specification', 1,'Did you find this page useful?','default',7,8,9);

INSERT INTO snippet  (id, note, templateId,data,groupname,yesAnswers, neutralAnswers, noAnswers)
VALUES ('4', 'Blog page about react', 1,'Did you find this page useful?','default',10,11,12);

INSERT INTO snippet  (id, note, templateId,data,groupname,yesAnswers, neutralAnswers, noAnswers)
VALUES ('5', 'Blog page about react and differences', 1,'Did you find this page useful?','default',13,14,15);

DROP TABLE IF EXISTS groups;

CREATE TABLE groups (
  id      VARCHAR(24) PRIMARY KEY ,
  name    VARCHAR(35),
  createdtime TIMESTAMP
);

INSERT INTO groups  (id, name,createdtime)
VALUES ('default', 'Default',now());

INSERT INTO groups  (id, name,createdtime)
VALUES ('group1', 'Group 1',now());

INSERT INTO app_role (id, role_name, description) VALUES (1, 'STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO app_role (id, role_name, description) VALUES (2, 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');

-- USER
-- non-encrypted password: jwtpass
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (1, 'John', 'Doe', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'john.doe');
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (2, 'Admin', 'Admin', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'admin.admin');


INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);



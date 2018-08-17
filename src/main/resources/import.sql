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

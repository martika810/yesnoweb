DROP TABLE IF EXISTS city;

CREATE TABLE snippet (
  id      VARCHAR(16) PRIMARY KEY ,
  note    VARCHAR(64),
  templateId   VARCHAR(24),
  data VARCHAR(64)
);

INSERT INTO snippet (NAME, state, country)
VALUES ('Beijing', 'BJ', 'CN');

INSERT INTO city (NAME, state, country)
VALUES ('Shanghai', 'SH', 'CN');

INSERT INTO city (NAME, state, country)
VALUES ('Guangzhou', 'GZ', 'CN');

INSERT INTO city (NAME, state, country)
VALUES ('Shenzhen', 'SZ', 'CN');

INSERT INTO city (NAME, state, country)
VALUES ('San Francisco', 'CA', 'US');
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
  confirmed BOOLEAN,
  sourceSite VARCHAR(24),
  createdtime TIMESTAMP default now()
);

INSERT INTO snippet (id, note, templateId,data,groupname,yesAnswers, neutralAnswers, noAnswers,confirmed)
VALUES ('1', 'Howto infrastructure page', 1,'Was this page useful?','default',1,2,3,TRUE);

INSERT INTO snippet  (id, note, templateId,data,groupname,yesAnswers, neutralAnswers, noAnswers,confirmed)
VALUES ('2', 'Training page about something ', 1,'Did you find this page useful?','default',4,5,6,FALSE);

INSERT INTO snippet  (id, note, templateId,data,groupname,yesAnswers, neutralAnswers, noAnswers,confirmed)
VALUES ('3', 'java position and specification', 1,'Did you find this page useful?','default',7,8,9,FALSE);

INSERT INTO snippet  (id, note, templateId,data,groupname,yesAnswers, neutralAnswers, noAnswers,confirmed)
VALUES ('4', 'Blog page about react', 1,'Did you find this page useful?','default',10,11,12,FALSE);

INSERT INTO snippet  (id, note, templateId,data,groupname,yesAnswers, neutralAnswers, noAnswers,confirmed)
VALUES ('5', 'Blog page about react and differences', 1,'Did you find this page useful?','default',13,14,15,FALSE);

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

drop table if exists oauth_client_details;
create table oauth_client_details (
  client_id VARCHAR(255) PRIMARY KEY,
  resource_ids VARCHAR(255),
  client_secret VARCHAR(255),
  scope VARCHAR(255),
  authorized_grant_types VARCHAR(255),
  web_server_redirect_uri VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(255)
);

drop table if exists oauth_client_token;
create table oauth_client_token (
  token_id VARCHAR(255),
  token VARBINARY,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255)
);

drop table if exists oauth_access_token;
create table oauth_access_token (
  token_id VARCHAR(255),
  token VARBINARY,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication VARBINARY,
  refresh_token VARCHAR(255)
);

drop table if exists oauth_refresh_token;
create table oauth_refresh_token (
  token_id VARCHAR(255),
  token VARBINARY,
  authentication VARBINARY
);

drop table if exists oauth_code;
create table oauth_code (
  code VARCHAR(255),
  authentication VARBINARY
);

drop table if exists oauth_approvals;
create table oauth_approvals (
    userId VARCHAR(255),
    clientId VARCHAR(255),
    scope VARCHAR(255),
    status VARCHAR(10),
    expiresAt TIMESTAMP,
    lastModifiedAt TIMESTAMP
);

drop table if exists ClientDetails;
create table ClientDetails (
  appId VARCHAR(255) PRIMARY KEY,
  resourceIds VARCHAR(255),
  appSecret VARCHAR(255),
  scope VARCHAR(255),
  grantTypes VARCHAR(255),
  redirectUrl VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additionalInformation VARCHAR(4096),
  autoApproveScopes VARCHAR(255)
);



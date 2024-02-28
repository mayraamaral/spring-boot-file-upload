CREATE SEQUENCE user_seq
    START WITH 1
    INCREMENT BY 1
  NO CYCLE;

CREATE TABLE users (
  id_user INTEGER PRIMARY KEY DEFAULT nextval('user_seq'),
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE
);

CREATE SEQUENCE profile_picture_seq
    START WITH 1
    INCREMENT BY 1
  NO CYCLE;

CREATE TABLE profile_picture (
  id_profile_picture INTEGER PRIMARY KEY DEFAULT nextval('profile_picture_seq'),
  file_type VARCHAR(255) NOT NULL,
  data BYTEA NOT NULL
);
ALTER TABLE users
    ADD id_profile_picture INTEGER;

ALTER TABLE users
    ADD CONSTRAINT fk_user_profile_picture FOREIGN KEY (id_profile_picture) REFERENCES profile_picture (id_profile_picture);
BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO collections (user_id,collection_name) VALUES (1,'testName');
INSERT INTO collections (user_id,collection_name) VALUES (1,'testName2');
INSERT INTO collections (user_id,collection_name) VALUES (2,'testName3');

INSERT INTO comics (title,thumbnail_url) VALUES ('testTitle','google.com');
INSERT INTO comics (title,thumbnail_url) VALUES ('testTitle1','google.com');
INSERT INTO comics (title,thumbnail_url) VALUES ('testTitle2','google.com');
INSERT INTO comics (title,thumbnail_url) VALUES ('testTitle3','google.com');
INSERT INTO comics (title,thumbnail_url) VALUES ('testTitle4','google.com');

INSERT INTO comics_collections (comic_id, collection_id) VALUES (1,1);
INSERT INTO comics_collections (comic_id, collection_id) VALUES (1,2);
INSERT INTO comics_collections (comic_id, collection_id) VALUES (2,3);
INSERT INTO comics_collections (comic_id, collection_id) VALUES (4,3);

COMMIT TRANSACTION;

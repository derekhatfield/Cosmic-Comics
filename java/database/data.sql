BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO collections (user_id,collection_name,visibility) VALUES (1,'testName','Public');
INSERT INTO collections (user_id,collection_name,visibility) VALUES (1,'testName2','Public');
INSERT INTO collections (user_id,collection_name,visibility) VALUES (2,'testName3','Public');

INSERT INTO comics (comic_author,comic_issue,comic_title,comic_series,comic_publisher) VALUES ('testAuthor',4,'testTitle','testSeries','testPublisher');
INSERT INTO comics (comic_author,comic_issue,comic_title,comic_series,comic_publisher) VALUES ('testAuthor2',2,'testTitle2','testSeries2','testPublisher2');
INSERT INTO comics (comic_author,comic_issue,comic_title,comic_series,comic_publisher) VALUES ('testAuthor3',4,'testTitle3','testSeries3','testPublisher3');
INSERT INTO comics (comic_author,comic_issue,comic_title,comic_series,comic_publisher) VALUES ('testAuthor4',1,'testTitle4','testSeries4','testPublisher4');
INSERT INTO comics (comic_author,comic_issue,comic_title,comic_series,comic_publisher) VALUES ('testAuthor5',4,'testTitle5','testSeries5','testPublisher5');

INSERT INTO comics_collections (comic_id, collection_id) VALUES (1,1);
INSERT INTO comics_collections (comic_id, collection_id) VALUES (1,2);
INSERT INTO comics_collections (comic_id, collection_id) VALUES (2,3);
INSERT INTO comics_collections (comic_id, collection_id) VALUES (4,3);

COMMIT TRANSACTION;

BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS comics;
DROP TABLE IF EXISTS collections;
DROP TABLE IF EXISTS comics_collections;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE comics (
   comic_id SERIAL,
   comic_author varchar(100) NOT NULL,
   comic_issue INT NOT NULL,
   comic_title varchar(100) NOT NULL,
   comic_series varchar(100) NOT NULL,
   comic_thumbnail_url varchar(100) NOT NULL,
   CONSTRAINT PK_comics PRIMARY KEY (comic_id)
);

CREATE TABLE collections (
    collection_id SERIAL,
    user_id INT NOT NULL,
    collection_name varchar(50) NOT NULL,
    CONSTRAINT PK_collections PRIMARY KEY (collection_id),
    CONSTRAINT FK_collections_users FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE comics_collections (
   comic_id INT,
   collection_id INT,
   CONSTRAINT FK_comics_collections_comics FOREIGN KEY (comic_id) REFERENCES comics (comic_id),
   CONSTRAINT FK_comics_collections_collections FOREIGN KEY (collection_id) REFERENCES collections (collection_id)
);

COMMIT TRANSACTION;

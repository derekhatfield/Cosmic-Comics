BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS comics;
DROP TABLE IF EXISTS collections;
DROP TABLE IF EXISTS characters;
DROP TABLE IF EXISTS comics_collections;
DROP TABLE IF EXISTS comics_characters;


CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE comics (
   comic_id SERIAL,
   title varchar(100) NOT NULL,
   thumbnail_url varchar(100),
   CONSTRAINT PK_comics PRIMARY KEY (comic_id)
);

CREATE TABLE collections (
    collection_id SERIAL,
    user_id INT NOT NULL,
    collection_name varchar(100) NOT NULL,
    CONSTRAINT PK_collections PRIMARY KEY (collection_id),
    CONSTRAINT FK_collections_users FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE characters (
    character_id SERIAL,
    name varchar(100) NOT NULL,
    thumbnail_url varchar(100),
    CONSTRAINT PK_characters PRIMARY KEY (character_id)
);

CREATE TABLE comics_collections (
   comic_id INT,
   collection_id INT,
   CONSTRAINT FK_comics_collections_comics FOREIGN KEY (comic_id) REFERENCES comics (comic_id),
   CONSTRAINT FK_comics_collections_collections FOREIGN KEY (collection_id) REFERENCES collections (collection_id)
);

CREATE TABLE comics_characters (
    comic_id INT,
    character_id INT,
    CONSTRAINT FK_comics_characters_comics FOREIGN KEY (comic_id) REFERENCES comics (comic_id),
    CONSTRAINT FK_comics_characters_characters FOREIGN KEY (character_id) REFERENCES characters (character_id)
);

COMMIT TRANSACTION;

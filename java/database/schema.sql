BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS comics;
DROP TABLE IF EXISTS collections;
DROP TABLE IF EXISTS characters;
DROP TABLE IF EXISTS series;
DROP TABLE IF EXISTS creators;
DROP TABLE IF EXISTS comics_collections;
DROP TABLE IF EXISTS comics_characters;
DROP TABLE IF EXISTS comics_creators;
DROP TABLE IF EXISTS comics_series;
DROP TABLE IF EXISTS series_creators;
DROP TABLE IF EXISTS series_characters;

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

CREATE TABLE series (
    series_id SERIAL,
    title varchar(100),
    thumbnail_url varchar(100),
    CONSTRAINT PK_series PRIMARY KEY (series_id)
);

CREATE TABLE creators (
    creator_id SERIAL,
    first_name varchar(50),
    last_name varchar(50),
    thumbnail_url varchar(100),
    CONSTRAINT PK_creators PRIMARY KEY (creator_id)
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

CREATE TABLE comics_creators (
    comic_id INT,
    creator_id INT,
    CONSTRAINT FK_comics_creators_comics FOREIGN KEY (comic_id) REFERENCES comics (comic_id),
    CONSTRAINT FK_comics_creators_creators FOREIGN KEY (creator_id) REFERENCES creators (creator_id)
);

CREATE TABLE comics_series (
    comic_id INT,
    series_id INT,
    CONSTRAINT FK_comics_series_comics FOREIGN KEY (comic_id) REFERENCES comics (comic_id),
    CONSTRAINT FK_comics_series_series FOREIGN KEY (series_id) REFERENCES series (series_id)
);

CREATE TABLE series_creators (
    series_id INT,
    creator_id INT,
    CONSTRAINT FK_series_creators_series FOREIGN KEY (series_id) REFERENCES series (series_id),
    CONSTRAINT FK_series_creators_creators FOREIGN KEY (creator_id) REFERENCES creators (creator_id)
);

CREATE TABLE series_characters (
    series_id INT,
    character_id INT,
    CONSTRAINT FK_series_characters_series FOREIGN KEY (series_id) REFERENCES series (series_id),
    CONSTRAINT FK_series_characters_characters FOREIGN KEY (character_id) REFERENCES characters (character_id)
);

COMMIT TRANSACTION;

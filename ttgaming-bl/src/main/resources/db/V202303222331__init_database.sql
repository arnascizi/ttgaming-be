CREATE SCHEMA ttgaming;

CREATE TABLE ttgaming.game
(
    id           SERIAL PRIMARY KEY,
    name         TEXT    NOT NULL,
    description  TEXT,
    min_players  INTEGER NOT NULL,
    max_players  INTEGER NOT NULL,
    min_age      INTEGER,
    duration     TEXT,
    image_url    TEXT,
    release_year INTEGER,
    rating       DECIMAL(3, 2) DEFAULT 0
);

CREATE TABLE ttgaming.designer
(
    id          SERIAL PRIMARY KEY,
    name        TEXT NOT NULL,
    description TEXT,
    website_url TEXT
);

CREATE TABLE ttgaming.publisher
(
    id          SERIAL PRIMARY KEY,
    name        TEXT NOT NULL,
    description TEXT,
    website_url TEXT
);

CREATE TABLE ttgaming.game_designers
(
    game_id     INTEGER REFERENCES ttgaming.game (id) ON DELETE CASCADE,
    designer_id INTEGER REFERENCES ttgaming.designer (id) ON DELETE CASCADE,
    PRIMARY KEY (game_id, designer_id)
);

CREATE TABLE ttgaming.game_publishers
(
    game_id      INTEGER REFERENCES ttgaming.game (id) ON DELETE CASCADE,
    publisher_id INTEGER REFERENCES ttgaming.publisher (id) ON DELETE CASCADE,
    PRIMARY KEY (game_id, publisher_id)
);

CREATE TABLE ttgaming.category
(
    id   SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE ttgaming.game_categories
(
    game_id     INTEGER REFERENCES ttgaming.game (id) ON DELETE CASCADE,
    category_id INTEGER REFERENCES ttgaming.category (id) ON DELETE CASCADE,
    PRIMARY KEY (game_id, category_id)
);

CREATE TABLE ttgaming.mechanic
(
    id   SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE game_mechanics
(
    game_id     INTEGER REFERENCES ttgaming.game (id) ON DELETE CASCADE,
    mechanic_id INTEGER REFERENCES ttgaming.mechanic (id) ON DELETE CASCADE,
    PRIMARY KEY (game_id, mechanic_id)
);

CREATE TABLE expansion
(
    id           SERIAL PRIMARY KEY,
    name         TEXT NOT NULL,
    description  TEXT,
    release_date INTEGER,
    image_url    TEXT,
    base_game_id INTEGER REFERENCES game (id) ON DELETE CASCADE
);

CREATE TABLE ttguser
(
    id         SERIAL PRIMARY KEY,
    username   TEXT      NOT NULL,
    email      TEXT      NOT NULL,
    password   TEXT      NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE ttgaming.review
(
    id         SERIAL PRIMARY KEY,
    user_id    INTEGER   NOT NULL,
    game_id    INTEGER   NOT NULL,
    rating     INTEGER   NOT NULL,
    comment    TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    FOREIGN KEY (user_id) REFERENCES ttgaming.ttguser (id) ON DELETE CASCADE,
    FOREIGN KEY (game_id) REFERENCES ttgaming.game (id) ON DELETE CASCADE
);

CREATE TABLE ttgaming.user_wishlist
(
    user_id INTEGER REFERENCES ttgaming.ttguser (id),
    game_id INTEGER REFERENCES ttgaming.game (id),
    PRIMARY KEY (user_id, game_id)
);

CREATE TABLE ttgaming.user_collection
(
    user_id INTEGER REFERENCES ttgaming.ttguser (id),
    game_id INTEGER REFERENCES ttgaming.game (id),
    PRIMARY KEY (user_id, game_id)
);

CREATE OR REPLACE FUNCTION update_review_updated_at()
    RETURNS TRIGGER AS
$$
BEGIN
    NEW.updated_at = NOW();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER review_updated_at
    BEFORE UPDATE
    ON review
    FOR EACH ROW
EXECUTE FUNCTION update_review_updated_at();

CREATE OR REPLACE FUNCTION update_game_rating_on_review() RETURNS TRIGGER AS
$$
BEGIN
    UPDATE game
    SET rating = (SELECT COALESCE(AVG(rating), 0)
                  FROM review
                  WHERE game_id = NEW.game_id)
    WHERE id = NEW.game_id;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_game_rating_trigger
    AFTER INSERT
    ON review
    FOR EACH ROW
EXECUTE FUNCTION update_game_rating_on_review();
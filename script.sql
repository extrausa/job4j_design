CREATE DATABASE idea_db;

CREATE TABLE users(user_pid SERIAL PRIMARY KEY, user_id UUID NOT NULL DEFAULT uuid_generate_v4(), user_name TEXT NOT NULL, user_email TEXT NOT NULL, user_balance INTEGER NOT NULL, user_registration TIMESTAMP NOT NULL DEFAULT now());

INSERT INTO users(user_name, user_email, user_balance) VALUES('Patrick', 'patrick@gav.eat', '100');

INSERT INTO users(user_name, user_email, user_balance) VALUES('Adam Smith', 'smith@com.gav', '130');

UPDATE users SET user_name = 'Patrick & Cash' WHERE user_pid = 1;

SELECT * FROM users

DROP TABLE users



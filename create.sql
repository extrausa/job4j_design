CREATE TABLE users(user_id SERIAL PRIMARY KEY, name TEXT);
CREATE TABLE user_role (id_role SERIAL PRIMARY KEY, role_name TEXT);
CREATE TABLE group_role_rules (id SERIAL PRIMARY KEY,
                            id_role INT REFERENCES user_role(id_role),
                            id_rules INT REFERENCES role_rules(id_rules));
CREATE TABLE role_rules (id_rules SERIAL PRIMARY KEY, rules_name TEXT);

CREATE TABLE item (id_item SERIAL PRIMARY KEY,
                id_user INT REFERENCES users(user_id),
                id_category INT REFERENCES category(id_category),
                id_state INT REFERENCES state(id_state),
                cost INT);
CREATE TABLE comment_application (id_comments SERIAL PRIMARY KEY, id_item INT REFERENCES item(id_item), name TEXT);
CREATE TABLE category (id_category SERIAL PRIMARY KEY, name TEXT);
CREATE TABLE attaches (id_attaches SERIAL PRIMARY KEY, id_item INT REFERENCES item(id_item), name TEXT);
CREATE TABLE state (id_state SERIAL PRIMARY KEY, name TEXT);
